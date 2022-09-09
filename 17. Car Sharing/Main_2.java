// 2. Companies

package carsharing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Company {
    private int id;
    private String name;

    Company(int id, String name) {
        this.id = id; this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

interface CompanyDao {
    public List<Company> getAllCompanies();
    public Company getCompany(int id);
    public void updateCompany(Company company);
    public void deleteCompany(Company company);
    public void listAllCompanies();
    public void addCompany();
}

class CompanyDaoImpl implements CompanyDao {
    List<Company> companies = new ArrayList<>();
    String JDBC_DRIVER;
    String DB_URL;


    CompanyDaoImpl(String JDBC_DRIVER, String DB_URL) {
        this.JDBC_DRIVER = JDBC_DRIVER; this.DB_URL = DB_URL;
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            // STEP 2 : Open a Connection
            conn = DriverManager.getConnection(DB_URL);

            // STEP 3 : Execute a Query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM COMPANY";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                Company company = new Company(id, name);
                companies.add(company);
            }

            // STEP 4 : Clean-up Environment
            rs.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void deleteCompany(Company company) {
        companies.remove(company.getId());
        // delete from database
    }

    @Override
    public List<Company> getAllCompanies() {
        // get list of companies from db
        return companies;
    }

    @Override
    public Company getCompany(int id) {
        return companies.get(id);
    }

    @Override
    public void updateCompany(Company company) {
        companies.get(company.getId()).setName(company.getName());
        // Update in database
    }

    @Override
    public void addCompany() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the company name: ");
        String name = sc.nextLine();
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            // STEP 2 : Open a Connection
            conn = DriverManager.getConnection(DB_URL);

            // STEP 3 : Execute a Query
            stmt = conn.createStatement();
            String sql = "INSERT INTO COMPANY (NAME) " + "VALUES ('" + name + "')";
            stmt.executeUpdate(sql);
            System.out.println("The company was created!");

            // STEP 4 : Clean-up Environment
            stmt.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void listAllCompanies() {
        int idx = 1;
        if (companies.isEmpty()) System.out.println("\nThe company list is empty!");
        else {
            System.out.println("\nCompany list:");
            for (Company company : companies) {
                System.out.printf("%d. %s\n", idx++, company.getName());
            }
        }
    }

}

public class Main {
    static Scanner sc = new Scanner(System.in);

    // JDBC Driver Name and Database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static String DB_URL = "jdbc:h2:~/IdeaProjects/Car Sharing/Car Sharing/task/src/carsharing/db/";
    static String db_filename = "test";
    static final String USER = "sa";
    static final String PASS = "";

    static void create_company_db() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            // STEP 2 : Open a Connection
            conn = DriverManager.getConnection(DB_URL + db_filename);

            // STEP 3 : Execute a Query
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS COMPANY " +
                    "(ID INTEGER AUTO_INCREMENT, " +
                    "NAME VARCHAR(50) UNIQUE NOT NULL," +
                    "PRIMARY KEY (ID))";
            stmt.executeUpdate(sql);

            // STEP 4 : Clean-up Environment
            stmt.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    static void managerMenu() {
        while (true) {
            System.out.println("\n1. Company list\n2. Create a company\n0. Back");
            int choice = sc.nextInt();
            if (choice == 0) break;
            CompanyDao companyDao = new CompanyDaoImpl(JDBC_DRIVER, DB_URL + db_filename);
            if (choice == 1) companyDao.listAllCompanies();
            else if (choice == 2) companyDao.addCompany();
        }
    }

    public static void main(String[] args) {
        // write your code here
        List<String> cmd = List.of(args);
        if (!cmd.isEmpty()) {
            int idx = cmd.indexOf("-databaseFileName");
            db_filename = cmd.get(idx + 1);
        }
        create_company_db();

        while (true) {
            int choice;
            System.out.println("1. Log in as a manager\n0. Exit");
            choice = sc.nextInt();
            if (choice == 0) break;
            else {
                managerMenu();
            }
        }
    }
}

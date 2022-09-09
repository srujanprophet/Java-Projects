// 3. Relationship

package carsharing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Company {
    private final int id;
    private String name;

    Company(int id, String name) {
        this.id = id; this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

class Car {
    private final int id;
    private String name;
    private final int company_id;

    Car(int id, String name, int company_id) {
        this.id = id; this.name = name; this.company_id = company_id;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getCompany_id() { return company_id; }

    public void setName(String name) { this.name = name; }
}

interface CompanyDao {
    List<Company> getAllCompanies();
    Company getCompany(int id);
    void updateCompany(Company company);
    void deleteCompany(Company company);
    void listAllCompanies();
    void addCompany();
}

interface CarDao {
    void listAllCars(int company_id);
    void addCar(int company_id);
}

class CarDaoImpl implements CarDao {
    List<Car> cars = new ArrayList<>();
    String JDBC_DRIVER;
    String DB_URL;
    Scanner sc = new Scanner(System.in);

    CarDaoImpl(String JDBC_DRIVER, String DB_URL) {
        this.JDBC_DRIVER = JDBC_DRIVER;
        this.DB_URL = DB_URL;
        updateList();
    }

    private void updateList() {
        cars.clear();
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            // STEP 2 : Open a Connection
            conn = DriverManager.getConnection(DB_URL);

            // STEP 3 : Execute a Query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAR";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int company_id = rs.getInt("COMPANY_ID");
                Car car = new Car(id, name, company_id);
                cars.add(car);
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
    public void listAllCars(int company_id) {
        int idx = 1;
        List<Car> companyCars = new ArrayList<>();
        for (Car car: cars) {
            if (car.getCompany_id() == company_id) companyCars.add(car);
        }
        if (companyCars.isEmpty()) System.out.println("\nThe car list is empty!");
        else {
            System.out.println("\nCar list:");
            for (Car car: companyCars) {
                System.out.printf("%d. %s\n", idx++, car.getName());
            }
        }
    }

    @Override
    public void addCar(int company_id) {
        System.out.println("\nEnter the car name: ");
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
            String sql = "INSERT INTO CAR (NAME, COMPANY_ID) " + "VALUES ('" + name + "', " + company_id + ")";
            stmt.executeUpdate(sql);
            System.out.println("The car was added!");

            // STEP 4 : Clean-up Environment
            stmt.close();
            conn.close();
            updateList();
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

}

class CompanyDaoImpl implements CompanyDao {
    List<Company> companies = new ArrayList<>();
    String JDBC_DRIVER;
    String DB_URL;
    Scanner sc = new Scanner(System.in);


    CompanyDaoImpl(String JDBC_DRIVER, String DB_URL) {
        this.JDBC_DRIVER = JDBC_DRIVER; this.DB_URL = DB_URL;
        updateList();
    }

    private void updateList() {
        companies.clear();
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
            updateList();
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

    private void carMenu(int company_id) {
        CarDaoImpl carDao = new CarDaoImpl(JDBC_DRIVER, DB_URL);
        System.out.printf("\n'%s' company:",  companies.get(company_id - 1).getName());
        while (true) {
            System.out.println("\n1. Car list\n2. Create a car\n0. Back");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) break;
            if (choice == 1) carDao.listAllCars(company_id);
            else if (choice == 2) carDao.addCar(company_id);
        }
    }

    @Override
    public void listAllCompanies() {
        if (companies.isEmpty()) System.out.println("\nThe company list is empty!");
        else {
            int idx = 1;
            System.out.println("\nChoose the company:");
            for (Company company : companies) {
                System.out.printf("%d. %s\n", idx++, company.getName());
            }
            System.out.println("0. Back");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 0) carMenu(choice);
        }
    }

}

public class Main {
    static Scanner sc = new Scanner(System.in);

    // JDBC Driver Name and Database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static String DB_URL = "jdbc:h2:~/IdeaProjects/Car Sharing/Car Sharing/task/src/carsharing/db/";
    static String db_filename = "test";

    static void init_db() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            // STEP 2 : Open a Connection
            conn = DriverManager.getConnection(DB_URL + db_filename);

            // STEP 3 : Execute a Query
            stmt = conn.createStatement();
            String create_company = "CREATE TABLE IF NOT EXISTS COMPANY " +
                    "(ID INTEGER AUTO_INCREMENT, " +
                    "NAME VARCHAR(50) UNIQUE NOT NULL," +
                    "PRIMARY KEY (ID))";
            stmt.executeUpdate(create_company);

            String create_car = "CREATE TABLE IF NOT EXISTS CAR " +
                    "(ID INTEGER AUTO_INCREMENT, " +
                    "NAME VARCHAR(40) UNIQUE NOT NULL, " +
                    "COMPANY_ID INTEGER NOT NULL," +
                    "PRIMARY KEY (ID)," +
                    "CONSTRAINT FK_COMPANY FOREIGN KEY (COMPANY_ID)" +
                    "REFERENCES COMPANY(ID))";
            stmt.executeUpdate(create_car);

            String testFix = "ALTER TABLE COMPANY ALTER COLUMN id RESTART WITH 1";
            stmt.executeUpdate(testFix);

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
        CompanyDao companyDao = new CompanyDaoImpl(JDBC_DRIVER, DB_URL + db_filename);
        while (true) {
            System.out.println("\n1. Company list\n2. Create a company\n0. Back");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) break;
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
        init_db();

        while (true) {
            int choice;
            System.out.println("1. Log in as a manager\n0. Exit");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) break;
            else {
                managerMenu();
            }
        }
    }
}

// 1. Initialization

package carsharing;

import java.sql.*;
import java.util.List;

public class Main {
    // JDBC Driver Name and Database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static String DB_URL = "jdbc:h2:~/IdeaProjects/Car Sharing/Car Sharing/task/src/carsharing/db/";

    // Database Credentials
    static final String USER = "sa";
    static final String PASS = "";

    static void create_company_db(String db_filename) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            // STEP 2 : Open a Connection
            conn = DriverManager.getConnection(DB_URL + db_filename);

            // STEP 3 : Execute a Query
            stmt = conn.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INTEGER not NULL, " +
                    "NAME VARCHAR(50))";
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

    public static void main(String[] args) {
        // write your code here
        String fileLocation = "test";
        List<String> cmd = List.of(args);
        if (!cmd.isEmpty()) {
            int idx = cmd.indexOf("-databaseFileName");
            fileLocation = cmd.get(idx + 1);
        }
        create_company_db(fileLocation);
    }
}

package database;

import java.sql.*;


public class Database {
    public void database() {
        Connection c;
        Statement stmt;

        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");
            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            // Create a statement for executing SQL queries
            stmt = c.createStatement();

            // Create the "PAYMENT_METHOD" table with columns: PAYMENT_METHOD
            String paymentMethod = "CREATE TABLE IF NOT EXISTS PAYMENTMETHOD " +
                    "(PAYMENTMETHOD TEXT  NOT NULL)";



            stmt.executeUpdate(paymentMethod);

            // Create the "STAFF" table with columns: FIRSTNAME, LASTNAME, USERNAME, and PASSWORD
            String staff = "CREATE TABLE IF NOT EXISTS STAFF " +
                    "(" +
                    " FIRSTNAME           TEXT    NOT NULL, " +
                    " LASTNAME           TEXT    NOT NULL, " +
                    " USERNAME           TEXT    NOT NULL, " +
                    " PASSWORD           TEXT    NOT NULL)";
            stmt.executeUpdate(staff);

            // Create the "USERS" table with columns: FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, and SALARY
            String users = "CREATE TABLE IF NOT EXISTS USERS " +
                    "(" +
                    " FIRSTNAME           TEXT    NOT NULL, " +
                    " LASTNAME           TEXT    NOT NULL, " +
                    " EMAIL           TEXT    NOT NULL, " +
                    " USERNAME           TEXT    NOT NULL, " +
                    " PASSWORD           TEXT    NOT NULL, " +
                    " SALARY         REAL)";
            stmt.executeUpdate(users);

            // Create the "PRODUCTS" table with columns: PRODUCT NAME, PRODUCTIVE, PRODUCT BRAND, and PRODUCTIVE
            String products = "CREATE TABLE IF NOT EXISTS PRODUCTS " +
                    "(" +
                    " PRODUCTNAME           TEXT    NOT NULL, " +
                    " PRODUCTCODE           TEXT    NOT NULL, " +
                    " PRODUCTBRAND           TEXT    NOT NULL, " +
                    " PRODUCTPRICE           TEXT    NOT NULL)";
            stmt.executeUpdate(products);

            // Close the statement and the connection to the database
            stmt.close();
            c.close();
        } catch (Exception e) {
            // If any exception occurs, print the error message and exit the program
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        // If no exceptions occur, print a success message
        System.out.println("Table created successfully");
    }
}

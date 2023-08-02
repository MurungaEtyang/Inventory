package retrieveData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseRetrieveProducts {
    public void retrieveProducts(){
        Connection c;
        Statement stmt;
        ResultSet rs;

        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");
            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            // Create a statement for executing SQL queries
            stmt = c.createStatement();

            // Execute a SELECT query to retrieve data from the "PRODUCT" table
            String query = "SELECT * FROM PRODUCTS";
            rs = stmt.executeQuery(query);

            // Iterate over the result set and print the retrieved data
            while (rs.next()) {
                String productName = rs.getString("PRODUCT_NAME");
                String productCode = rs.getString("PRODUCT_CODE");
                String productBrand = rs.getString("PRODUCT_BRAND");
                String productPrice = rs.getString("PRODUCT_PRICE");


                System.out.println("Product: " + productName);
                System.out.println("Code: " + productCode);
                System.out.println("Brand: " + productBrand);
                System.out.println("price: " + productPrice);
                System.out.println("--------------------");
            }

            // Close the result set, statement, and the connection to the database
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            // If any exception occurs, print the error message and exit the program
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}

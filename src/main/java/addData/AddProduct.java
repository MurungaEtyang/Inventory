package addData;

import java.sql.*;
import java.util.Scanner;

public class AddProduct {

    public void insertProduct() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Declare variables to store product details
        Connection c;
        Statement stmt;

        // Prompt the user to enter product details
        System.out.println("Enter product name: ");
        String productName = scanner.next();
        System.out.println("Enter product code: ");
        int productCode = scanner.nextInt();
        System.out.println("Enter product brand: ");
        String productBrand = scanner.next();
        System.out.println("Enter product price: ");
        int productPrice = scanner.nextInt();

        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");
            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            c.setAutoCommit(false);

            // Create a statement for executing SQL queries
            stmt = c.createStatement();

            // Create an SQL query to insert product details into the "PRODUCTS" table
            String sql = "INSERT INTO PRODUCTS (PRODUCTNAME,PRODUCTCODE,PRODUCTBRAND,PRODUCTPRICE) " +
                    "VALUES ('"+productName+"', '"+ productCode +"', '"+productBrand+"', " +
                    "'"+productPrice+"')";
            // Execute the SQL query to insert the data
            stmt.executeUpdate(sql);

            // Close the statement and commit the changes to the database
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            // If any exception occurs, print the error message and exit the program
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        // If no exceptions occur, print a success message
        System.out.println("Records created successfully");
    }
}

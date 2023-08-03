package sale;

import paymentMethodProcessing.Payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class PointOfSale {
    public void pos() {
        System.out.println("Hello, welcome to the Point of Sale system!");
        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");
            // Connect to the SQLite database named "Inventory.db"
            Connection c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            // Create a statement for executing SQL queries
            Statement stmt = c.createStatement();

            // Execute a SELECT query to retrieve data from the "PRODUCTS" table
            String query = "SELECT * FROM PRODUCTS";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(rs.getString("PRODUCT_CODE"));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Product");
            // Display product information
            while (rs.next()) {
                String productCode = rs.getString("PRODUCT_CODE");
                double productPrice = rs.getDouble("PRODUCT_PRICE");
                String productName = rs.getString("PRODUCT_NAME");

                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
                System.out.println("Product Price: " + productPrice);

                System.out.println("Select method of payment:");
                System.out.println("1. Cash");
                System.out.println("2. Mobile payment");
                System.out.println("3. Bank transfer");
                System.out.println("4. Card transfer");
                int method = scanner.nextInt();

                if (method == 1) {
                    System.out.println("Enter amount from customer: ");
                    double amount = scanner.nextDouble();
                    double change = amount - productPrice;
                    change = Math.round(change * 100.0) / 100.0;
                    System.out.println("Cash: " + amount);
                    System.out.println("Change: " + change);
                } else if (method >= 2 && method <= 4) {
                    Payment payment = new Payment();
                    if (method == 2) {
                        payment.mobilePayment();
                    } else if (method == 3) {
                        payment.bankTransfer();
                    } else {
                        payment.cardPayment();
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            // Close the result set, statement, and the connection to the database
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            // If any exception occurs, print the error message
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

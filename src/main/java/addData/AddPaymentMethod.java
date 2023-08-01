package addData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AddPaymentMethod {
    public void insertPayment() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Declare variables to store payment details
        Connection c;
        Statement stmt;
        // Prompt the user to enter payment details
        System.out.println("Enter payment method: ");
        String paymentMethod = scanner.next();
        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            c.setAutoCommit(false);

            // Create a statement for executing SQL queries
            stmt = c.createStatement();

            // Create an SQL query to insert payment details into the "PAYMENT" table
            String payment = "INSERT INTO PAYMENTMETHOD (PAYMENTMETHODTEXT) " +
                    "VALUES('" + paymentMethod + "')";

            // Execute the SQL query to insert the data
            stmt.executeUpdate(payment);

            // Close the statement and commit the changes to the database
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            // If any exception occurs, print the error message and exit the program
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // If no exceptions occur, print a success message
        System.out.println("Payment added successfully");
    }
}
package paymentMethod;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class MobilePayment {
    public void mobileTransfer(int phoneNumber, String transactionId, String phoneOwner) {
        Connection c;
        Statement stmt;

        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            // Create an SQL query to insert payment details into the "Mobile PAYMENT" table
            String payment = "INSERT INTO MOBILE_PAYMENT (PHONE_NUMBER, TRANSACTION_ID, PHONE_OWNER) " +
                    "VALUES('" + phoneNumber + "', '" + transactionId + "', '" + phoneOwner + "')";

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
    }
}

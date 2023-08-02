package paymentMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BankTransfer {
    public void bankTransfer(int accountNumber, String transactionId, String phoneOwner) {
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
            String payment = "INSERT INTO BANK_PAYMENT (ACCOUNT_NUMBER, TRANSACTION_ID, PHONE_OWNER) " +
                    "VALUES('" + accountNumber + "', '" + transactionId + "', '" + phoneOwner + "')";

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

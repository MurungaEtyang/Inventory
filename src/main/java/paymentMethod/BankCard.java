package paymentMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BankCard {

    public BankCard(String user, int cardNumber, String cardName, int expirationDate, int cvvNumber) {
        Connection c;
        Statement stmt;
        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            // Create an SQL query to insert payment details into the "PAYMENT" table
            String payment = "INSERT INTO CARD_DETAILS (USER, CARD_NUMBER, CARD_NAME, EXPIRATION_DATE, CVV) " +
                    "VALUES('" + user + "', '" + cardNumber + "', '" + cardName + "', " +
                    "'" + expirationDate+"', '" + cvvNumber + "')";

            // Execute the SQL query to insert the data
            stmt.executeUpdate(payment);

            // Close the statement and commit the changes to the database
            stmt.close();
            c.commit();
            c.close();

        }
        catch (Exception e) {
            // If any exception occurs, print the error message and exit the program
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}

package addData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AddStaff {
    public void addStaff() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Declare variables to store staff details
        Connection c;
        Statement stmt;

        // Prompt the user to enter staff details
        System.out.println("Enter first name: ");
        String firstName = scanner.next();
        System.out.println("Enter last name: ");
        String lastName = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("password: ");
        String password = scanner.next();

        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");

            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            c.setAutoCommit(false);

            // Create a statement for executing SQL queries
            stmt = c.createStatement();

            // Create an SQL query to insert staff details into the "STAFF" table
            String staff = "INSERT INTO STAFF (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) " +
                    "VALUES('" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "')";

            // Execute the SQL query to insert the data
            stmt.executeUpdate(staff);

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
        System.out.println("Records created successfully");
    }
}

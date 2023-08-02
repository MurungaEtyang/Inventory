package retrieveData;
import java.sql.*;

public class DatabaseRetrieveStaff  {
    public void retrieveData(){
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

            // Execute a SELECT query to retrieve data from the "USERS" table
            String query = "SELECT * FROM STAFF";
            rs = stmt.executeQuery(query);

            // Iterate over the result set and print the retrieved data
            while (rs.next()) {
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String username = rs.getString("USERNAME");


                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Username: " + username);
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
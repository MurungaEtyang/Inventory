package retrieveData;

import java.sql.*;

public class DatabaseRetrieveUsers {
    public void retrieveData() {
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
            String query = "SELECT * FROM USERS";
            rs = stmt.executeQuery(query);

            // Iterate over the result set and print the retrieved data
            while (rs.next()) {
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String email = rs.getString("EMAIL");
                String username = rs.getString("USERNAME");
                double salary = rs.getDouble("SALARY");

                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Email: " + email);
                System.out.println("Username: " + username);
                System.out.println("Salary: " + salary);
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
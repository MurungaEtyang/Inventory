package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    public boolean authenticateUser() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their username and password
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // Perform authentication logic here (e.g., check against a database)

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
            String query = "SELECT * FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
            rs = stmt.executeQuery(query);

            // Check if the result set has any rows
            if (rs.next()) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
                rs.close();
                stmt.close();
                c.close();
                return false;
            }

            // Close the result set, statement, and the connection to the database
        } catch (Exception e) {
            // If any exception occurs, print the error message and exit the program
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return false;
    }
}
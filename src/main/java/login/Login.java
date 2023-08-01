package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    public void authenticateUser() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt the user to enter their username and password
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter password: ");
            String password = scanner.nextLine();

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
                    System.out.println("Hello "+ username + "! You have successfully logged in! Let's do a bit of admin stuff.");
                    break;
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }

                rs.close();
                stmt.close();
                c.close();
                // Close the result set, statement, and the connection to the database
            } catch (Exception e) {
                // If any exception occurs, print the error message and continue the loop
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }
}

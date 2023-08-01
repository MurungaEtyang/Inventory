package addData;

import java.sql.*;
import java.util.Scanner;

public class AddUser {

    public void insertUser() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Declare variables to store user details
        Connection c;
        Statement stmt;

        // Prompt the user to enter user details
        System.out.println("Enter first name: ");
        String firstName = scanner.next();
        System.out.println("Enter last name: ");
        String lastName = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        System.out.println("Enter salary: ");
        int salary = scanner.nextInt();

        try {
            // Load the JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");
            // Connect to the SQLite database named "Inventory.db"
            c = DriverManager.getConnection("jdbc:sqlite:Inventory.db");
            c.setAutoCommit(false);

            // Create a statement for executing SQL queries
            stmt = c.createStatement();

            // Create an SQL query to insert user details into the "USERS" table
            String sql = "INSERT INTO USERS (FIRSTNAME,LASTNAME,EMAIL,USERNAME,PASSWORD,SALARY) " +
                    "VALUES ('"+firstName+"', '"+ lastName +"', '"+email+"', " +
                    "'"+username+"', '"+password+"','"+salary+"')";
            // Execute the SQL query to insert the data
            stmt.executeUpdate(sql);

            // Close the statement and commit the changes to the database
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            // If any exception occurs, print the error message and exit the program
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        // If no exceptions occur, print a success message
        System.out.println("Records created successfully");
    }
}

package main;

import addData.AddProduct;
import addData.AddStaff;
import database.Database;
import addData.AddUser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Print menu options for the user
        System.out.println("1. Create Table.\n2. Add users.\n3. Add product\n4. Add staff");

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        try {
            // Read the user's choice
            int input = scanner.nextInt();

            if (input == 1) {
                // Option 1: Create the database tables
                Database db = new Database();
                db.database();
            } else if (input == 2) {
                // Option 2: Add users to the database
                AddUser users = new AddUser();
                users.insertUser();
            } else if (input == 3) {
                // Option 3: Add products to the database
                AddProduct product = new AddProduct();
                product.insertProduct();
            } else if (input == 4) {
                // Option 4: Add staff to the database
                AddStaff staff = new AddStaff();
                staff.addStaff();
            } else {
                // If the user enters an invalid choice
                System.out.println("Select the right choice");
            }
        } catch (Exception e) {
            // If the user enters non-numeric input
            System.out.println(e.getMessage() + ": Only numbers are allowed");
        }
    }
}

package main;
import addData.AddPaymentMethod;
import addData.AddProduct;
import addData.AddStaff;
import database.Database;
import addData.AddUser;
import retrieveData.DatabaseRetrieveStaff;
import retrieveData.DatabaseRetrieveUsers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Print menu options for the user
        System.out.println("""
                1. Create Table.
                2. Add users.
                3. Add product
                4. Add staff
                5. Users list
                6. Staff list
                7. Add payment method
                """);

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
            }else if (input == 5) {
                // Option 4:FETCH USERS from the database
                DatabaseRetrieveUsers users = new DatabaseRetrieveUsers();
                users.retrieveData();
            }else if (input == 6) {
                // Option 4: FETCH STAFF from the database
                DatabaseRetrieveStaff staff = new DatabaseRetrieveStaff();
                staff.retrieveData();
            }

            else if (input == 7) {
                // Option 4: Add payment
                AddPaymentMethod payment = new AddPaymentMethod();
                payment.insertPayment();

            }

            else {
                // If the user enters an invalid choice
                System.out.println("Select the right choice");
            }
        } catch (Exception e) {
            // If the user enters non-numeric input
            System.out.println(e.getMessage() + ": Only numbers are allowed");
        }
    }
}

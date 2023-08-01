package main;
import addData.AddProduct;
import addData.AddStaff;
import database.Database;
import addData.AddUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Create Table.\n2. Add users.\n3. Add product\n4. Add staff");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");

        try {
            int input = scanner.nextInt();
            if (input == 1) {
            Database db = new Database();
            db.database();
            } else if (input == 2) {
                AddUser users = new AddUser();
                users.insertUser();
            }else  if (input == 3) {
                AddProduct product = new AddProduct();
                product.insertProduct();
            }else  if (input == 4) {
                AddStaff staff= new AddStaff();
                staff.addStaff();
            }
            else{
                System.out.println("select the right number");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage() + ": only numbers are allowed");
        }
    }
}













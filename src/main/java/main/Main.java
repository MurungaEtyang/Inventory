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


//        AddUsers user = new AddUsers();
//        user.run();
//
//
//        String productName;
//        double productCode;
//        String brand;
//        double productPrice;
//        ShelfOfProducts shelf = new ShelfOfProducts();
//            while (true){
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Enter product name: ");
//                productName = scanner.next();
//                System.out.print("Enter product code: ");
//                productCode = scanner.nextDouble();
//                System.out.print("Enter product brand: ");
//                brand = scanner.next();
//                System.out.print("Enter product brand: ");
//                productPrice = scanner.nextDouble();
//                Product product = new Product(productName, productCode, brand, productPrice);
//                shelf.add(product);
//                System.out.print("Do you want to stop? ");
//                if (scanner.next().equals("yes")){
//                    break;
//                }
//            }
//
//        System.out.print(shelf);

    }
}













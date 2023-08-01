package org.example;

import java.util.Scanner;

public class AddUsers {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String secondName = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter role: ");
        String role = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        Users users = new Users(firstName, secondName, email, role, password);

        ShelfOfUsers user = new ShelfOfUsers();
        user.add(users);
        System.out.println(user);
    }
}

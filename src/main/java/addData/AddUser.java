package addData;

import java.sql.*;
import java.util.Scanner;

public class AddUser {

   public void insertUser() {
      Scanner scanner = new Scanner(System.in);
      Connection c = null;
      Statement stmt = null;

      System.out.println("Enter first name: ");
      String firstName = scanner.next();
      System.out.println("Enter last name: ");
      String lastName = scanner.next();
      System.out.println("Enter email: ");
      String email = scanner.next();
      System.out.println("Enter username: ");
      String username = scanner.next();
      System.out.println("Enter password");
      String password = scanner.next();
      System.out.println("Enter salary: ");
      int salary = scanner.nextInt();

      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:sample.db");
         c.setAutoCommit(false);

         stmt = c.createStatement();

         String sql = "INSERT INTO USERS (FIRSTNAME,LASTNAME,EMAIL,USERNAME,PASSWORD,SALARY) " +
                        "VALUES ('"+firstName+"', '"+ lastName +"', '"+email+"', " +
                 "'"+username+"', '"+password+"','"+salary+"')";
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}
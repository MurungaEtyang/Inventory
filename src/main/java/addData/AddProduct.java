package addData;

import java.sql.*;
import java.util.Scanner;

public class AddProduct {

   public void insertProduct() {
      Scanner scanner = new Scanner(System.in);
      Connection c = null;
      Statement stmt = null;

      System.out.println("Enter product name: ");
      String productName = scanner.next();
      System.out.println("Enter product code: ");
      double productCode = scanner.nextDouble();
      System.out.println("Enter product brand: ");
      String productBrand = scanner.next();
      System.out.println("Enter product price: ");
      double productPrice = scanner.nextDouble();

      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:sample.db");
         c.setAutoCommit(false);

         stmt = c.createStatement();

         String sql = "INSERT INTO PRODUCTS (ID,PRODUCTNAME,PRODUCTCODE,PRODUCTBRAND,PRODUCTPRICE) " +
                        "VALUES ('1', '"+productName+"', '"+ productCode +"', '"+productBrand+"', " +
                 "'"+productPrice+"')";
         stmt.executeUpdate(sql);


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
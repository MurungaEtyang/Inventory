package database;

import java.sql.*;


public class Database {
  public  void database() {
      Connection c = null;
      Statement stmt = null;

      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:sample.db");

         stmt = c.createStatement();
         String users = "CREATE TABLE USERS " +
                        "(ID INT PRIMARY KEY UNIQUE NOT NULL," +
                        " FIRSTNAME           TEXT    NOT NULL, " +
                        " LASTNAME           TEXT    NOT NULL, " +
                        " EMAIL           TEXT    NOT NULL, " +
                        " USERNAME           TEXT    NOT NULL, " +
                        " PASSWORD           TEXT    NOT NULL, " +
                        " SALARY         REAL)";
         stmt.executeUpdate(users);

         String products = "CREATE TABLE PRODUCTS " +
                        "(ID INT PRIMARY KEY  UNIQUE NOT NULL," +
                        " PRODUCTNAME           TEXT    NOT NULL, " +
                        " PRODUCTCODE           TEXT    NOT NULL, " +
                        " PRODUCTBRAND           TEXT    NOT NULL, " +
                        " PRODUCTPRICE           TEXT    NOT NULL)";
         stmt.executeUpdate(products);
         stmt.close();

         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
}
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
         String sql = "CREATE TABLE USERS " +
                        "(ID INT PRIMARY KEY NOT NULL" +
                        " FIRSTNAME           TEXT    NOT NULL, " +
                        " LASTNAME            TEXT     NOT NULL, " +
                        " EMAIL        CHAR(50), " +
                        " USERNAME TEXT NOT NULL, " +
                        " PASSWORD TEXT NOT NULL, " +
                        " SALARY         REAL)";
         stmt.executeUpdate(sql);
         stmt.close();

         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
}
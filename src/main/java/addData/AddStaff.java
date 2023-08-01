package addData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class AddStaff {
    public void addStaff(){
          Scanner scanner = new Scanner(System.in);
          Connection c;
          Statement stmt;

          System.out.println("Enter first name: ");
          String firstName = scanner.next();
          System.out.println("Enter last name: ");
          String lastName = scanner.next();
          System.out.println("Enter email: ");
          String email = scanner.next();
          System.out.println("password: ");
          String  password = scanner.next();

          try {
              Class.forName("org.sqlite.JDBC");
              c = DriverManager.getConnection("jdbc:sqlite:sample.db");
              c.setAutoCommit(false);

              stmt = c.createStatement();

              String staff = "INSERT INTO STAFF (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) " +
                      "VALUES('"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"')";

              stmt.executeUpdate(staff);

              stmt.close();
              c.commit();
              c.close();
          }catch(Exception e){
               System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
    }
}

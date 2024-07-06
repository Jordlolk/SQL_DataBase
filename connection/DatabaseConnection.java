
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Your_database_name";
    private static final String USER = "user";
    public  static Connection getConnection() {
        try {
            System.out.println("SYSTEM NOTIFICATION:: Connection executed with success!");
            return DriverManager.getConnection(URL, USER, null);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error while trying to connect to the data base: " + e.getMessage());
        }
    }
}
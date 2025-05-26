import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
        System.out.println("Connected to MySQL!");
        conn.close();
        new RegistrationForm();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}

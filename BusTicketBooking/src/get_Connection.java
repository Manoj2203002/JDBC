import java.sql.Connection;
import java.sql.DriverManager;

public class get_Connection {
    public static Connection connection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bus_Ticket", "root", "Manoj");
        return con;
    }
}


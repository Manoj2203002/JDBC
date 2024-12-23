import java.sql.Connection;
import java.sql.PreparedStatement;
public class UsersDAO {
    public void insertUsers(Connection con,Users u) throws Exception{
        String query= "Insert into bus_ticket.users (name,address,phone,email) values (?,?,?,?)";
        PreparedStatement pre =con.prepareStatement(query);
        pre.setString(1,u.getname());
        pre.setString(2,u.getaddress());
        pre.setString(3,u.getphone());
        pre.setString(4,u.getEmail());
        pre.executeUpdate();
    }
    public void updateusers(Connection con,Users u) throws Exception{
        String query= "Update Bus_Ticket.users set name=?,address=?,phone=? where email=?";
        PreparedStatement pre =con.prepareStatement(query);
        pre.setString(1,u.getname());
        pre.setString(2,u.getaddress());
        pre.setString(3,u.getphone());
        pre.setString(4,u.getEmail());
        pre.executeUpdate();
    }
}
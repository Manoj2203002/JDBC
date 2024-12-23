
import java.sql.*;

public class BookingDAO {

    // Booking new Ticket

    public void newbooking(Connection  con,Booking b) throws Exception{
        String query="Insert into Bus_Ticket.Booking (UserId,email,name,Gender,age,From_date,Booked_Date,From_Place,To_Place,No_of_seats,status,seatno) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(query);
        pre.setInt(1,b.getUserId());
        pre.setString(2,b.getEmail());
        pre.setString(3,b.getName());
        pre.setString(4, b.getGender());
        pre.setInt(5,b.getAge());
        pre.setDate(6,b.getDate());
        pre.setDate(7,b.getBooked_Date());
        pre.setString(8,b.getFrom_Place());
        pre.setString(9,b.getTo_Place());
        pre.setInt(10,b.getNo_of_seats());
        pre.setString(11,b.getStatus());
        pre.setString(12,b.getseatno());
        pre.executeUpdate();
    }

    // Cancel Booking

    public void CancleBooking(Connection con,Booking b) throws Exception{
        final String query="Update bus_ticket.booking set Status='Canceled' where email=? AND Booked_Date=?";
        PreparedStatement Pre=con.prepareStatement(query);
        Pre.setString(1,b.getEmail());
        Pre.setDate(2,b.getBooked_Date());
        Pre.executeUpdate();
    }

    // Check History

    public ResultSet CheckbookingHistory(Connection con,String email) throws Exception{
        String select = "select * from Bus_Ticket.booking where email=?";
            PreparedStatement ps = con.prepareStatement(select);
            ps.setString(1, email);
            ResultSet data = ps.executeQuery();
            return data;
    }

    // Ticket Generation

    public ResultSet TicketGenerate(Connection con, String email, Date Booked) throws  Exception{
        String select = "select * from Bus_Ticket.booking where email=? AND Booked_Date=?";
        PreparedStatement ps = con.prepareStatement(select);
        ps.setString(1, email);
        ps.setDate(2,Booked);
        ResultSet data = ps.executeQuery();
        return data;
    }

}



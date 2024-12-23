import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Services {
    Validation validation;
    UsersDAO users;
    BookingDAO booking;
    public Services(){
        validation=new Validation();
        users=new UsersDAO();
        booking=new BookingDAO();
    }

    // Creating A new Users
    public void Newusers( String name,String address,String phone,String email) throws Exception {
        Connection con=get_Connection.connection();
        con.setAutoCommit(false);
        Users u=new Users();
        u.setEmail(email);
        u.setname(name);
        u.setaddress(address);
        u.setphone(phone);
        users.insertUsers(con,u);
        con.commit();
        System.out.println("======================================================");
        System.out.println();
        System.out.println("Record Inserted Successfully");
        System.out.println();
        System.out.println("======================================================");
    }
    //Checking the User Detials

    public void checkusers(String email) throws Exception {
        Connection con=get_Connection.connection();
        ResultSet data=validation.validation(con,email);
        System.out.println("========================================================");
        System.out.println("User Details");
        System.out.println("========================================================");
        while(data.next()) {
            System.out.println(" UserId   :"+data.getInt(1) + "\n Email   :" + data.getString(2) + "\n Name   :" + data.getString(3) + "\n Address   :" + data.getString(4) + "\n Phone   :" + data.getString(5));
        }
        System.out.println();
        System.out.println("========================================================");
    }
    // Updating Existing Users
    public void updateuser( String email,String name,String address,String phone) throws Exception{
        Connection con=get_Connection.connection();
        Users u=new Users();
        con.setAutoCommit(false);
        u.setEmail(email);
        u.setname(name);
        u.setaddress(address);
        u.setphone(phone);
        users.updateusers(con,u);
        con.commit();
        System.out.println("========================================================");
        System.out.println();
        System.out.println("Updated Successfully");
        System.out.println();
        System.out.println("========================================================");
    }
    // Inserting Record into Booking

    public void NewBooking(int age,String Gender,String Email,Date Booked,int no_of_seats,String From,String To,String Seatno) throws Exception {
     Connection con=get_Connection.connection();
     Booking b=new Booking();
     con.setAutoCommit(false);
     String query="Select UserId,name from bus_Ticket.users where email=?";
     PreparedStatement pre=con.prepareStatement(query);
     pre.setString(1,Email);
     ResultSet data= pre.executeQuery();
     String status="Confirmed";
     Date date=new Date(new java.util.Date().getTime());
     if(data.next()){
        int Userid=data.getInt("UserId");
        String name=data.getString("name");
        b.setUserid(Userid);
        b.setName(name);
        b.setAge(age);
        b.setNo_of_seats(no_of_seats);
        b.setEmail(Email);
        b.setGender(Gender);
        b.setDate(date);
        b.setBooked_Date(Booked);
        b.setFrom_Place(From);
        b.setTo_Place(To);
        b.setStatus(status);
        b.setseatno(Seatno);
        booking.newbooking(con,b);
        con.commit();
         System.out.println("========================================================");
         System.out.println();
         System.out.println("Ticket Booked Successfully");
         System.out.println();
         System.out.println("========================================================");
     }
    }
    // CheckBooking History

    public  void checkbooking(String email) throws Exception{
        Connection con=get_Connection.connection();
        ResultSet data=booking.CheckbookingHistory(con,email);
        System.out.println("========================================================");
        System.out.println();
        // Checking Ticket History
        while(data.next()) {
            System.out.println("Ticket Id      : " + data.getInt(1));
            System.out.println("User Id        : " + data.getInt(2));
            System.out.println("Email          : " + data.getString(3));
            System.out.println("Name           : " + data.getString(4));
            System.out.println("Gender         : " + data.getString(5));
            System.out.println("Age            : " + data.getInt(6));
            System.out.println("Booking Date   : " + data.getDate(7));
            System.out.println("Booked Date    : " + data.getDate(8));
            System.out.println("Boarding Point : " + data.getString(9));
            System.out.println("Destination    : " + data.getString(10));
            System.out.println("No_of_Seats    : " + data.getInt(11));
            System.out.println("Status         : " + data.getString(12));
            System.out.println("Seat No        : " + data.getString(13));
            System.out.println("--------------------------------------------------------");

        }
        System.out.println();
        System.out.println("========================================================");
    }
    //Check Status

    public void Status(String email,Date booked) throws Exception{
        Connection con= get_Connection.connection();
        ResultSet data=booking.TicketGenerate(con,email,booked);
        System.out.println("========================================================");
        System.out.println("Status");
        System.out.println("========================================================");
        while(data.next()){
            System.out.println(data.getString("Status"));
        }
        System.out.println();
        System.out.println("========================================================");
    }

    // Generate Ticket

    public void Generate_Ticket(String email, Date Booked_date) throws Exception {

        Connection con = get_Connection.connection(); // Establishing connection
        ResultSet data = booking.TicketGenerate(con, email, Booked_date);

            System.out.println("========================================================");
            System.out.println("Ticket Generating");
            System.out.println("========================================================");

            boolean ticketFound = false;
            while (data.next()) {
                ticketFound = true; // At least one ticket found

                // Check if the ticket is canceled
                String status = data.getString("Status");
                if (status.equals("Canceled")) {
                    System.out.println("The Ticket was canceled.");
                    continue;
                }
                // Display ticket details
                System.out.println("Ticket Id      : " + data.getInt(1));
                System.out.println("User Id        : " + data.getInt(2));
                System.out.println("Email          : " + data.getString(3));
                System.out.println("Name           : " + data.getString(4));
                System.out.println("Gender         : " + data.getString(5));
                System.out.println("Age            : " + data.getInt(6));
                System.out.println("Booking Date   : " + data.getDate(7));
                System.out.println("Booked Date    : " + data.getDate(8));
                System.out.println("Boarding Point : " + data.getString(9));
                System.out.println("Destination    : " + data.getString(10));
                System.out.println("No_of_Seats    : " + data.getInt(11));
                System.out.println("Status         : " + data.getString(12));
                System.out.println("Seat No        : " + data.getString(13));
                System.out.println("--------------------------------------------------------");
            }

            if (!ticketFound) {
                System.out.println("No tickets found for the given email and booking date.");
            }
        System.out.println();
        System.out.println("========================================================");
    }


    // Cancel Booking

    public void CancelBooking(String Email,Date Booked_Date) throws Exception{
        Connection con=get_Connection.connection();
        Booking b=new Booking();
        b.setEmail(Email);
        b.setBooked_Date(Booked_Date);
        booking.CancleBooking(con,b);
        con.setAutoCommit(true);
        System.out.println("========================================================");
        System.out.println();
        System.out.println("Booking Canceled");
        System.out.println();
        System.out.println("========================================================");
    }
    public boolean UserId_validation (String email) throws Exception{
            Connection con= get_Connection.connection();
            ResultSet rs=validation.validation(con,email);
            while(rs.next())
            {
                System.out.println(rs.getString("email"));
                if (rs.getString("email").equals(email)) return false;
            }
            con.close();
        return true;
    }
    public boolean Booking_Validation(String Email) throws Exception{
        Connection con=get_Connection.connection();
        ResultSet data=validation.validation(con,Email);
        while(data.next()){
            if(data.getString("email").equals(Email)) return true;
        }
        return false;
    }
}
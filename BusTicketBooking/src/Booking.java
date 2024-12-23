import java.sql.Date;
public class Booking {
    private int UserId;
    private Date Date;
    private String From_Place;
    private String To_Place;
    private String seatno;
    private String status;
    private String email;
    private Date Booked_Date;
    private String name;
    private String Gender;
    private int age;
    private int no_of_seats;

    public void setUserid(int UserId){
        this.UserId=UserId;
    }

    public int getUserId(){
        return this.UserId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setDate(Date Date){
        this.Date=Date;
    }

    public Date getDate() {
        return this.Date;
    }

    public void setBooked_Date(Date Booked_Date) {
        this.Booked_Date = Booked_Date;
    }

    public Date getBooked_Date() {
        return this.Booked_Date;
    }

    public void setFrom_Place(String From_Place) {
        this.From_Place = From_Place;
    }

    public String getFrom_Place(){
        return this.From_Place;
    }

    public void setTo_Place(String To_Place) {
        this.To_Place = To_Place;
    }

    public String getTo_Place() {
        return this.To_Place;
    }

    public void setseatno(String seatno) {
        this.seatno = seatno;
    }

    public  String getseatno(){
        return this.seatno;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getGender() {
        return Gender;
    }

    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }

    public int getNo_of_seats() {
        return no_of_seats;
    }
}
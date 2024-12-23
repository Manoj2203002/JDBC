import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BusticketUi {
    static String name;
    static String address;
    static String phone;
    static String email;
    static String From;
    static String To;
    static String seatno;
    static String Booked;
    static String Gender;
    Scanner sc=new Scanner(System.in);
    Services services=new Services();
    String choices= null;
    static Validation v1=new Validation();
    public BusticketUi() throws Exception {
        do{
            try {
                System.out.println("Enter Your choice\n1.Click 1 to create new User \n2.Check 2 Your profile data \n3.Click 3 Update Your Profile \n4.Click 4 to Book The Ticket \n5.Click 5 to Cancel The Ticket \n6.Click 6 to Check the status \n7.Click 7 to Generate the ticket \n8.Click 8 To Check Booking History \n9.Click 9 to Exit");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        // Inserting new User
                        System.out.println("Enter the User MailId");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.UserId_validation(email)) {
                                System.out.println("Enter Your name");
                                name = sc.nextLine();
                                if(v1.isValidName(name)) {
                                    System.out.println("Enter your address");
                                    address = sc.nextLine();
                                    if(v1.isValidAddress(address)) {
                                        System.out.println("Enter your phone");
                                        phone = sc.nextLine();
                                        if(v1.isValidPhone(phone)) {
                                            services.Newusers(name, address, phone, email);
                                        }else System.out.println("Enter Valid Phone");
                                    }else System.out.println("Enter Valid Address");
                                }else System.out.println("Enter Valid Name");
                            } else System.out.println("Your Mail Id is Already there");
                        } else System.out.println("Entered Email patten is Wrong");
                        System.out.println("Enter Y to Continue or Press any other key to Exit");
                        choices =sc.next();
                        break;
                    // Checking the user Details
                    case 2:
                        System.out.println("Enter your User Mail Id");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.Booking_Validation(email)) {
                                services.checkusers(email);
                            } else System.out.println("Enter Correct User Email");
                        } else System.out.println("Entered Email Patten is Wrong");
                        System.out.println("Enter Y to Continue or Press any other key to Exit");
                        choices =sc.next();
                        break;
                    case 3:
                        System.out.println("Enter the User Email");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.Booking_Validation(email)) {
                                System.out.println("Enter Your name");
                                name = sc.nextLine();
                                if(v1.isValidName(name)) {
                                    System.out.println("Enter your address");
                                    address = sc.nextLine();
                                    if(v1.isValidAddress(address)) {
                                        System.out.println("Enter your phone");
                                        phone = sc.nextLine();
                                        if(v1.isValidPhone(phone)) {
                                            services.updateuser(email, name, address, phone);
                                        } else System.out.println("Enter Valid Phone number");
                                    }else System.out.println("Enter Valid Address");
                                }else System.out.println("Enter Valid Date ");
                            } else System.out.println("Enter Correct User Email");
                        } else System.out.println("The Email Patten is Wrong");
                        System.out.println("Enter Y to Continue or Press any other key to Exit");
                        choices =sc.next();
                        break;
                    case 4:
                        System.out.println("Enter The User Email Id");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.Booking_Validation(email)) {
                                System.out.println("Enter Your Gender(Male,Female,Others,M,F,O)");
                                Gender=sc.nextLine();
                                System.out.println("Enter Your age");
                                int age=sc.nextInt();
                                if(v1.isValidGender(Gender)) {
                                    System.out.println("Enter Booking Date (yyyy-mm-dd)");
                                    Booked=sc.next();
                                    try {
                                        Date booked = Date.valueOf(Booked);
                                        sc.nextLine();
                                        if (v1.Date_validation(String.valueOf(booked))) {
                                            System.out.println("Enter The Boding Point");
                                            From = sc.nextLine();
                                            System.out.println("Enter the Destination");
                                            To = sc.nextLine();
                                            System.out.println("Enter the no of seats");
                                            int No_ofseats=sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Enter The seatno");
                                            seatno = sc.nextLine();
                                            services.NewBooking(age,Gender, email, booked, No_ofseats, From,To,seatno);
                                        } else System.out.println("Enter Valid Date");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid Date Format");
                                    }
                                }else System.out.println("Enter Valid Gender");
                            } else System.out.println("Enter Correct User Email");
                        } else System.out.println("Entered Email Patten is Wrong");
                        System.out.println("Enter Y to Continue or Press any other key to Exit");
                        choices =sc.next();
                        break;
                    case 5:
                        System.out.println("Enter the User Email Id");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.Booking_Validation(email)) {
                                System.out.println("Enter the Booked Date (yyyy-mm-dd)");
                                Booked=sc.next();
                                sc.nextLine();
                                try {
                                    Date booked = Date.valueOf(Booked);
                                    services.CancelBooking(email, booked);
                                } catch (IllegalArgumentException e){
                                    System.out.println("Invalid Date Format");
                                }
                            } else System.out.println("Enter Correct User Email");
                        } else System.out.println("Entered Email Patten is Wrong");
                        System.out.println("Enter Y to Continue or Press any other key to Exit");
                        choices =sc.next();
                        break;
                    case 6:
                        System.out.println("Enter the User Mail Id");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.Booking_Validation(email)) {
                                try {
                                    System.out.println("Enter Booked Date");
                                    Booked=sc.next();
                                    sc.nextLine();
                                    Date booked=Date.valueOf(Booked);
                                    services.Status(email,booked);
                                }catch (IllegalArgumentException e){
                                    System.out.println("Invalid Date Formate");
                                }
                            } else System.out.println("Your Email is not there");
                        } else System.out.println(" Enter Correct Email Patten");
                        System.out.println("Enter Y to Continue or Press other key to Exit");
                        choices =sc.next();
                        break;
                    case 7:
                        System.out.println("Enter User Email Id");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.Booking_Validation(email)) {
                                System.out.println("Enter the Booked Date (yyyy-mm-dd)");
                                Booked=sc.next();
                                sc.nextLine();
                                try {
                                    Date booked = Date.valueOf(Booked);
                                    services.Generate_Ticket(email, booked);
                                } catch (IllegalArgumentException e){
                                    System.out.println("Invalid Date Format");
                                }
                            } else System.out.println("Enter Correct User Email");
                        } else System.out.println("Entered Email Patten is Wrong");
                        System.out.println("Enter Y to Continue or Press any other To Exit");
                        choices =sc.next();
                        break;
                    case 8:
                        System.out.println("Enter Your User Mail Id");
                        email = sc.nextLine();
                        if (v1.isValidEmail(email)) {
                            if (services.Booking_Validation(email)) {
                                services.checkbooking(email);
                            } else System.out.println(" Your Email Id is Not There");
                        } else System.out.println("Entered Email Patten is wrong");
                        System.out.println("Enter Y to Continue or Press any To Exit");
                        choices =sc.next();
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Enter Valid Input to Process");
                }
            } catch (InputMismatchException e){
                System.out.println("Enter Valid Input");
            }
    }while(choices.equals("Y")||choices.equals("y"));
    }
}

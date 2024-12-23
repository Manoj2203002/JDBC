import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_REGEX = "^[a-z0-9._%+-]+@gmail\\.com$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public ResultSet validation(Connection con,String email){
        String select = "select * from Bus_Ticket.users where email=?";
        try {
            PreparedStatement ps = con.prepareStatement(select);
            ps.setString(1, email);
            ResultSet data = ps.executeQuery();
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
        public boolean Date_validation(String booked) {
            // Current date
            LocalDate today = LocalDate.now();
            // Maximum allowed booking date (15 days from today)
            LocalDate maxDate = today.plusDays(30);

            try {
                // Parse the input date string into a LocalDate object
                LocalDate fromDateParsed = LocalDate.parse(booked);

                // Validate that the booking date is not in the past
                if (fromDateParsed.isBefore(today)) {
                    return false;
                }
                // Validate that the booking date is not more than 15 days from today
                else if (fromDateParsed.isAfter(maxDate)) {
                    return false;
                }

                // If all checks pass, return true (valid date)
                return true;

            } catch (DateTimeParseException e) {
                // Handle invalid date formats
                System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
                return false;
            }
        }
        // Name validation method
        public boolean isValidName(String name) {
            return name != null && name.matches("^[a-zA-Z\\s]+$");
        }

        // Address validation method
        public boolean isValidAddress(String address) {
            return address != null && address.matches("^[a-zA-Z0-9\\s,.-]+$");
        }

        // Phone validation method
        public boolean isValidPhone(String phone) {
            return phone != null && phone.matches("^\\d{10}$");
        }
    public boolean isValidGender(String gender) {
        // Convert the input to lowercase and compare it with valid gender options
        return gender != null && (gender.equalsIgnoreCase("male") ||
                gender.equalsIgnoreCase("female") ||
                gender.equalsIgnoreCase("other")) ||
                gender.equalsIgnoreCase("m") ||
                gender.equalsIgnoreCase("f") ||
                gender.equalsIgnoreCase("o");
    }


}
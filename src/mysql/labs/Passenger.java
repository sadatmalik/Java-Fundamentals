package mysql.labs;

public class Passenger {

    private String firstName;
    private String lastName;
    private String passportNum;
    private String emailAddress;

    public Passenger(String firstName, String lastName, String passportNum, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNum = passportNum;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNum='" + passportNum + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

package mysql.labs;


/*
*  MySQL Exercise 4:
*
*   Now that you have mastered your air travel database, it's time to connect this DB to a Java application
*   using JDBC. You can start simple here and build your way up. Within a Java application, using JDBC, please
*   demonstrate how to:
*
*   Note: CRUD means (Create, Read, Update, Delete)
*
*       1.) CRUD new flights
*       2.) CRUD new passengers
*       3.) Bonus: flex those JDBC muscles! How nice, clean, useful can you make this? Show us what you've got!
*
 */

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// @TODO Add neater Flight and Passenger print methods

public class Exercise_04 {

    private static Connection dbConnection;

    public static void main(String[] args) {

        JDBCConnection database = new JDBCConnection("localhost", 3306, "air_travel",
                "sadat", "pa55word");

        dbConnection = database.getConnection();

        System.out.println("Got connection to DB: " + database.getSchemaName());

        Flight flight = new Flight(Plane.BOEING_747, Airline.AMERICAN_AIRLINES, "AA203",
                Location.NEW_YORK, Location.DUBAI,
                new Date(121, 8, 19, 16, 30),
                new Date(121, 8, 19, 22, 00));


        // 1. Create flights - method overloading

        // createFlight(flight);
        // createFlight(3, 1, "BA009", 1, Timestamp.valueOf("2021-09-08 15:00:00"), 8, Timestamp.valueOf("2021-09-08 23:00:00"));

        // 2. Get today's flight info
        ArrayList<Flight> flights = getFlights();
        System.out.println("\nFlights today: ");
        for (Flight f : flights) {
            System.out.println(f);
        }
        System.out.println();

        // 3. Get flights between two specific cities on a specific day
        flights = getFlights(Location.LONDON, Location.NEW_YORK, new Date(121, 8, 8));
        System.out.println("\nFlights between London and New York on Sept 8 2021 : ");
        for (Flight f : flights) {
            System.out.println(f);
        }
        System.out.println();

        // 4. Update flightNum
        int rows = updateFlights("SG2055", "SG204");
        System.out.println("\nFlights Updated - " + rows + " row(s)\n");

        // 5. Delete flight with a given flight number
        createFlight(3, 1, "BA999", 1, Timestamp.valueOf("2021-09-08 15:00:00"), 8, Timestamp.valueOf("2021-09-08 23:00:00"));
        rows = deleteFlight("BA999");
        System.out.println("\nFlights Deleted - " + rows + " row(s)\n");

        // 6. Create passenger
        createPassenger("Sadat", "Malik", "123456789", "sadat@coding.org");
        Passenger passenger = new Passenger("Edwardinia", "Rompannen",
                "76548975", "er@fin.net");
        createPassenger(passenger);

        // 7. Query passengers flyind between two cities
        ArrayList<Passenger> passengers = getPassengers(Location.LONDON, Location.NEW_YORK);
        System.out.println("All passengers flying from London to New York:");
        for (Passenger p : passengers) {
            System.out.println(p);
        }

        // 8. Update passport number for passenger by name
        rows = updatePassportNumForPassenger("Edwardinia", "Rompannen", "7654321");
        System.out.println("\nPassengers Updated - " + rows + " row(s)\n");

        // 9. Delete passenger by name
        rows = deletePassengerByName("Edwardinia", "Gabor");
        System.out.println("\nPassengers Deleted - " + rows + " row(s)\n");

        database.close();
    }

    private static void createPassenger(Passenger passenger) {

        createPassenger(passenger.getFirstName(), passenger.getLastName(),
                passenger.getPassportNum(), passenger.getEmailAddress());
    }

    private static void createPassenger(String firstName, String lastName,
                                        String passportNum, String email) {

        String sql = "INSERT INTO passengers " +
                "(first_name, last_name, passport_num, email_address) " +
                "VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, passportNum);
            ps.setString(4, email);

            System.out.println(ps);

            ps.executeUpdate();
            ps.close();

            System.out.println("Inserted Passenger into DB: " +

                    "Passenger{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", passportNum='" + passportNum + '\'' +
                    ", emailAddress='" + email + '\'' +
                    '}');

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Passenger> getPassengers(Location source, Location dest) {

        ArrayList<Passenger> passengers = new ArrayList<>();

        String sql = "SELECT p.first_name, p.last_name, p.passport_num, p.email_address " +
                "FROM passengers p " +
                "JOIN tickets t " +
                "ON p.id = t.passenger_id " +
                "JOIN flights f " +
                "ON t.flight_id = f.id " +
                "WHERE f.source = ? " +
                "AND f.destination = ?";

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setInt(1, source.getLocationId());
            ps.setInt(2, dest.getLocationId());

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();
            passengers = parsePassengerResultSet(rs);

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passengers;

    }

    private static int updatePassportNumForPassenger(String firstName, String lastName, String newPassportNum) {
        String sql = "UPDATE passengers " +
                "SET passport_num = ? " +
                "WHERE first_name = ? " +
                "AND last_name = ?;";

        int rowsAffected = 0;

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setString(1, newPassportNum);
            ps.setString(2, firstName);
            ps.setString(3, lastName);

            rowsAffected = ps.executeUpdate();

            ps.close();

        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    private static int deletePassengerByName(String firstName, String lastName) {

        String sql = "DELETE FROM passengers " +
                "WHERE first_name = ? " +
                "AND last_name = ?";

        int rowsAffected = 0;

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setString(1, firstName);
            ps.setString(2, lastName);

            rowsAffected = ps.executeUpdate();

            ps.close();

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return rowsAffected;
    }

    private static void createFlight(Flight flight) {

        createFlight(flight.getPlaneType().getId(),
                flight.getAirline().getAirlineId(),
                flight.getFlightNum(),
                flight.getSource().getLocationId(),
                new Timestamp(flight.getDepartureDateTime().getTime()),
                flight.getDestination().getLocationId(),
                new Timestamp(flight.getArrivalDateTime().getTime()));

    }

    private static void createFlight(int planeId, int airlineId, String flightNum,
                                     int source, Timestamp departure, int destination,
                                     Timestamp arrival) {

        String sql = "INSERT INTO flights " +
                "(plane_id, airline_id, flight_num, source, " +
                "departure_time, destination, arrival_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setInt(1, planeId);
            ps.setInt(2, airlineId);
            ps.setString(3, flightNum);
            ps.setInt(4, source);
            ps.setTimestamp(5, departure);
            ps.setInt(6, destination);
            ps.setTimestamp(7, arrival);

            System.out.println(ps);

            ps.executeUpdate();
            ps.close();

            System.out.println("Inserted Flight into DB: " +

            "Flight{" +
                    "planeType=" + planeId +
                    ", airline=" + airlineId +
                    ", flightNum='" + flightNum + '\'' +
                    ", source=" + source +
                    ", destination=" + destination +
                    ", departureDateTime=" + departure +
                    ", arrivalDateTime=" + arrival +
                    '}');

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get flights for today
    private static ArrayList<Flight> getFlights() {
        Date date = new Date();
        return getFlights(date);
    }

    // Get flights for a specific date
    private static ArrayList<Flight> getFlights(Date date) {
        ArrayList<Flight> flights = new ArrayList<>();

        String sql = "SELECT * FROM flights " +
                "WHERE CAST(departure_time AS DATE) = ?;";

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateAsString = formatter.format(date);

            ps.setString(1, dateAsString);

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();
            flights = parseResultSet(rs);

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    // Get flights between two cities for a particular date
    private static ArrayList<Flight> getFlights(Location source, Location destination, Date date) {
        ArrayList<Flight> flights = new ArrayList<>();

        String sql = "SELECT * FROM flights " +
                "WHERE CAST(departure_time AS DATE) = ? " +
                "AND source = ? " +
                "AND destination = ?;";

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateAsString = formatter.format(date);

            ps.setString(1, dateAsString);
            ps.setInt(2, source.getLocationId());
            ps.setInt(3, destination.getLocationId());

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();
            flights = parseResultSet(rs);

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    private static int updateFlights(String oldFlightNum, String newFlightNum) {

        String sql = "UPDATE flights " +
                "SET flight_num = ? " +
                "WHERE flight_num = ?;";

        int rowsAffected = 0;

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setString(1, oldFlightNum);
            ps.setString(2, newFlightNum);

            System.out.println(ps);

            rowsAffected = ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;

    }

    private static int deleteFlight(String flightNum) {
        String sql = "DELETE FROM flights " +
                "WHERE flight_num = ?;";

        int rowsAffected = 0;

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setString(1, flightNum);

            System.out.println(ps);

            rowsAffected = ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    // @TODO consider moving all these static DB query methods as instance methods of some standalone class
    private static ArrayList<Flight> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Flight> flights = new ArrayList<>();

        while (rs.next()) {

            int planeId = rs.getInt(2);
            int airlineId = rs.getInt(3);
            String flightNum = rs.getString(4);
            int sourceId = rs.getInt(6);
            String departure = rs.getString(7);
            int destId = rs.getInt(8);
            String arrival = rs.getString(9);

            System.out.println("Got Flight data from DB: " +
                    "Flight{" +
                    "planeType=" + planeId +
                    ", airline=" + airlineId +
                    ", flightNum='" + flightNum + '\'' +
                    ", source=" + sourceId +
                    ", destination=" + destId +
                    ", departureDateTime=" + departure +
                    ", arrivalDateTime=" + arrival +
                    '}');

            Plane planeType = Plane.from(planeId);
            Airline airline = Airline.from(airlineId);
            Location src = Location.from(sourceId);
            Location dest = Location.from(destId);

            try {
                Date d = JDBCConnection.getDateFormat().parse(departure);
                Date a = JDBCConnection.getDateFormat().parse(arrival);

                Flight flight = new Flight(planeType, airline, flightNum, src, dest, d, a);

                flights.add(flight);

                System.out.println("Converted to Flight object : " + flight);

            } catch (ParseException e) {
                System.out.println("Unable to parse date string : " + departure);
                e.printStackTrace();
            }
        }

        return flights;
    }

    private static ArrayList<Passenger> parsePassengerResultSet(ResultSet rs) throws SQLException {
        ArrayList<Passenger> passengers = new ArrayList<>();

        while (rs.next()) {

            String firstName = rs.getString(1);
            String lastName = rs.getString(2);
            String passportNum = rs.getString(3);
            String emailAddress = rs.getString(4);

            System.out.println("Got Passenger data from DB: " +
                    "Passenger{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", passportNum='" + passportNum + '\'' +
                    ", emailAddress='" + emailAddress + '\'' +
                    '}');

            Passenger passenger = new Passenger(firstName, lastName, passportNum, emailAddress);

            passengers.add(passenger);

            System.out.println("Converted to Passenger object : " + passenger);

        }

        return passengers;
    }

}

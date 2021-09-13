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

public class Exercise_04 {

    private static Connection dbConnection;

    public static void main(String[] args) {

        JDBCConnection database = new JDBCConnection("localhost", 3306, "air_travel",
                "sadat", "pa55word");

        dbConnection = database.getConnection();

        System.out.println("Got connection to DB: " + database.getSchemaName());

        Flight flight = new Flight(Plane.BOEING_747, Airline.AMERICAN_AIRLINES, "AA203",
                Location.NEW_YORK, Location.DUBAI,
                new Date(121, 8, 18, 16, 30),
                new Date(121, 8, 18, 22, 00));

        // createFlight(flight);

        ArrayList<Flight> flightsToday = getFlightsToday();
        // @TODO Add a nicer Flight display method
        System.out.println("Flights today: ");
        for (Flight f : flightsToday) {
            System.out.println(f);
        }


        /*

        These have all been tested then commented out to prevent duplication on re-run:

        createFlight(3, 1, "BA009", 1, Timestamp.valueOf("2021-09-08 15:00:00"),
                8, Timestamp.valueOf("2021-09-08 23:00:00"));

        @TODO:
        queryFlight(...);
        updateFlight(...);
        deleteFlight(...);

        createPassenger(...);
        queryPassenger(...);
        updatePassenger(...);
        deletePassenger(...);
         */
        

        database.close();
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

    private static void createFlight(Flight flight) {

        String sql = "INSERT INTO flights " +
                "(plane_id, airline_id, flight_num, source, " +
                "departure_time, destination, arrival_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = dbConnection.prepareStatement(sql);

            ps.setInt(1, flight.getPlaneType().getId());
            ps.setInt(2, flight.getAirline().getAirlineId());
            ps.setString(3, flight.getFlightNum());
            ps.setInt(4, flight.getSource().getLocationId());
            ps.setTimestamp(5, new Timestamp(flight.getDepartureDateTime().getTime()));
            ps.setInt(6, flight.getDestination().getLocationId());
            ps.setTimestamp(7, new Timestamp(flight.getArrivalDateTime().getTime()));

            System.out.println(ps);

            ps.executeUpdate();
            ps.close();

            System.out.println("Inserted Flight into DB: " + flight.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Flight> getFlightsToday() {
        Date date = new Date();
        return getFlightsByDate(date);
    }

    private static ArrayList<Flight> getFlightsByDate(Date date) {
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

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }


}

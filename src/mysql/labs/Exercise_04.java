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
                new Date(121, 8, 17, 16, 30),
                new Date(121, 8, 17, 22, 00));

        // createFlight(flight);


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

            ps.executeUpdate();

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

            ps.executeUpdate();

            System.out.println("Inserted Flight into DB: " + flight.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

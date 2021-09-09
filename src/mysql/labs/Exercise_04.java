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

public class Exercise_04 {

    private static Connection connection;

    public static void main(String[] args) {

        JDBCConnection jdbc = new JDBCConnection("localhost", 3306, "air_travel",
                "sadat", "pa55word");

        connection = jdbc.getConnection();



        createFlight(3, 1, "BA009", 1, Timestamp.valueOf("2021-09-08 15:00:00"),
                8, Timestamp.valueOf("2021-09-08 23:00:00"));

        /*

        These have all been tested then commented out to prevent duplication on re-run:


        @TODO:
        queryFlight(...);
        updateFlight(...);
        deleteFlight(...);

        createPassenger(...);
        queryPassenger(...);
        updatePassenger(...);
        deletePassenger(...);
         */
        

        jdbc.close();
    }

    private static void createFlight(int planeId, int airlineId, String flightNum,
                                     int source, Timestamp departure, int destination,
                                     Timestamp arrival) {

        String sql = "INSERT INTO flights " +
                "(plane_id, airline_id, flight_num, source, " +
                "departure_time, destination, arrival_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, planeId);
            ps.setInt(2, airlineId);
            ps.setString(3, flightNum);
            ps.setInt(4, source);
            ps.setTimestamp(5, departure);
            ps.setInt(6, destination);
            ps.setTimestamp(7, arrival);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

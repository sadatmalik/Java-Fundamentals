package mysql.labs;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    Connection connection;
    String schemaName;

    public JDBCConnection(String hostname, int port, String dbname,
                          String username, String password) {

        try {
            // 1. Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect
            String connectionUrl = "jdbc:mysql://" + hostname + ":" + port +
                    "/" + dbname;

            connection = DriverManager.getConnection(connectionUrl, username, password);
            schemaName = hostname + "/" + dbname;

            //

        } catch (ClassNotFoundException cnfe) {
            // Unable to load driver
            System.out.println("Unable to load driver - class not found");
            cnfe.printStackTrace();

        } catch (SQLException sqe) {
            System.out.println("Unable to connect to DB");
            sqe.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void close() {

        try {
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error closing DB connection");
            e.printStackTrace();
        }

    }


}

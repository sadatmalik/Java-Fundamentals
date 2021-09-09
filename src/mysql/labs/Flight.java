package mysql.labs;

import java.util.Date;

public class Flight {

    private Plane planeType;
    private Airline airline;
    private String flightNum;
    private Location source;
    private Location destination;
    private Date departureDateTime;
    private Date arrivalDateTime;

    public Flight(Plane planeType, Airline airline, String flightNum,
                  Location source, Location destination,
                  Date departureDateTime, Date arrivalDateTime) {

        this.planeType = planeType;
        this.airline = airline;
        this.flightNum = flightNum;
        this.source = source;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;

    }

    public Plane getPlaneType() {
        return planeType;
    }

    public Airline getAirline() {
        return airline;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }
}

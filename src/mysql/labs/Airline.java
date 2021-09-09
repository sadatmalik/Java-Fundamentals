package mysql.labs;

public enum Airline {
    BRITISH_AIRWAYS(1),
    SINGAPORE_AIRLINES(2),
    AMERICAN_AIRLINES(3),
    CATHAY_PACIFIC(4),
    JAPAN_AIRWAYS(5),
    VIRGIN(6),
    EMIRATES(7);

    int airlineId;

    private Airline(int id) {
        airlineId = id;
    }

    public int getAirlineId() {
        return airlineId;
    }
}

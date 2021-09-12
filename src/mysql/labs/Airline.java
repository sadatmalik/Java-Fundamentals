package mysql.labs;

import java.util.HashMap;
import java.util.Map;

public enum Airline {
    BRITISH_AIRWAYS(1),
    SINGAPORE_AIRLINES(2),
    AMERICAN_AIRLINES(3),
    CATHAY_PACIFIC(4),
    JAPAN_AIRWAYS(5),
    VIRGIN(6),
    EMIRATES(7);

    private final int airlineId;

    private static final Map<Integer, Airline> airlineById;

    static {
        airlineById = new HashMap<>();
        for (Airline a : Airline.values()) {
            airlineById.put(a.getAirlineId(), a);
        }
    }

    private Airline(int id) {
        airlineId = id;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public static Airline from (int id) {
        return airlineById.get(id);
    }
}

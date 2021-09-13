package mysql.labs;

import java.util.HashMap;
import java.util.Map;

//@TODO: Can all these kinds of enums have their id details loaded in from the DB on initialisation??
public enum Location {
    LONDON(1),
    TOKYO(2),
    SINGAPORE(3),
    KUALA_LUMPAR(5),
    NEW_YORK(6),
    HONG_KONG(8),
    SHANGHAI(9),
    SYDNEY(12),
    DUBAI(14);

    private final int locationId;

    private static final Map<Integer, Location> locationsById;
    
    static {
        locationsById = new HashMap();
        for (Location loc : Location.values()) {
            locationsById.put(loc.locationId, loc);
        }
    }

    private Location(int id) {
        locationId = id;
    }

    public int getLocationId() {
        return locationId;
    }

    public Location from(int id) {
        return locationsById.get(id);
    }
}

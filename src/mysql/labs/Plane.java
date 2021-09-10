package mysql.labs;

import java.util.HashMap;
import java.util.Map;

public enum Plane {

    BOEING_777(1),
    BOEING_747(2),
    AIRBUS_740(3),
    LOCKHEED_TAIL_STAR(4);

    private final int id;
    private static final Map<Integer, Plane> planeById;

    static {
        planeById = new HashMap<Integer, Plane>();
        for (Plane plane: Plane.values()) {
            planeById.put(plane.id, plane);
        }
    }

    private Plane(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Plane from (int id) {
        return planeById.get(id);
    }
}

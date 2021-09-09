package mysql.labs;

public enum Plane {

    BOEING_777(1),
    BOEING_747(2),
    AIRBUS_740(3),
    LOCKHEED_TAIL_STAR(4);

    private final int id;

    private Plane(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

package labs_examples.objects_classes_methods.labs.objects;
// The Airplane class must be composed of at least 4 other classes (as well as any primitive types you'd like).
// The Airplane class itself should have a fuel capacity (double) variable, as well as a currentFuelLevel variable.

import java.util.Arrays;

public class AirplaneExample {
    public static void main(String[] args) {
        FlightPath path = new FlightPath("London", "New York", 3000);
        Engine engine = new Engine(6000);
        Cockpit pit = new Cockpit(5, 10000, new Dashboard("Black", 25));
        Pilot pilot = new Pilot("Fred Johnson", 45, 13);
        Crew crew = new Crew(8, "Blue",
                new String[] {"Lisa", "Betty", "Alice", "Edward", "Tom", "John", "Janice", "Emily"});

        Airplane plane = new Airplane(path, engine, pit, pilot, crew, 230, 10000, 10000);

        System.out.println(plane);
    }
}

class Airplane {
    private FlightPath path;
    private Engine engine;
    private Cockpit pit;
    private Pilot pilot;
    private Crew crew;

    private int seats;
    private double fuelCapacity;
    private double currentFuelLevel;

    public Airplane(FlightPath path, Engine engine, Cockpit pit, Pilot pilot,
                    Crew crew, int seats, double fuelCapacity, double currentFuelLevel) {
        this.path = path;
        this.engine = engine;
        this.pit = pit;
        this.pilot = pilot;
        this.crew = crew;
        this.seats = seats;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
    }

    public FlightPath getPath() {
        return path;
    }

    public void setPath(FlightPath path) {
        this.path = path;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cockpit getPit() {
        return pit;
    }

    public void setPit(Cockpit pit) {
        this.pit = pit;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "path=" + path.toString() +
                ",\n engine=" + engine.toString() +
                ",\n pit=" + pit.toString() +
                ",\n pilot=" + pilot.toString() +
                ",\n crew=" + crew.toString() +
                ", seats=" + seats +
                ", fuelCapacity=" + fuelCapacity +
                ", currentFuelLevel=" + currentFuelLevel +
                '}';
    }
}

class FlightPath {
    String origin;
    String destination;
    int distance;

    public FlightPath(String origin, String destination, int distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "FlightPath{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                '}';
    }
}

class Cockpit {
    int numSeats;
    int capacity;
    Dashboard dash;

    public Cockpit(int numSeats, int capacity, Dashboard dash) {
        this.numSeats = numSeats;
        this.capacity = capacity;
        this.dash = dash;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Dashboard getDash() {
        return dash;
    }

    public void setDash(Dashboard dash) {
        this.dash = dash;
    }

    @Override
    public String toString() {
        return "Cockpit{" +
                "numSeats=" + numSeats +
                ", capacity=" + capacity +
                ", dash=" + dash.toString() +
                '}';
    }
}

class Dashboard {
    String colour;
    int numDials;

    public Dashboard(String colour, int numDials) {
        this.colour = colour;
        this.numDials = numDials;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNumDials() {
        return numDials;
    }

    public void setNumDials(int numDials) {
        this.numDials = numDials;
    }

    @Override
    public String toString() {
        return "Dashboard{" +
                "colour='" + colour + '\'' +
                ", numDials=" + numDials +
                '}';
    }
}

class Pilot {
    String name;
    int age;
    int yearsExperience;

    public Pilot(String name, int age, int yearsExperience) {
        this.name = name;
        this.age = age;
        this.yearsExperience = yearsExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", yearsExperience=" + yearsExperience +
                '}';
    }
}

class Crew {
    int members;
    String uniformColour;
    String[] names;

    public Crew(int members, String uniformColour, String[] names) {
        this.members = members;
        this.uniformColour = uniformColour;
        this.names = names;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getUniformColour() {
        return uniformColour;
    }

    public void setUniformColour(String uniformColour) {
        this.uniformColour = uniformColour;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "members=" + members +
                ", uniformColour='" + uniformColour + '\'' +
                ", names=" + Arrays.toString(names) +
                '}';
    }
}
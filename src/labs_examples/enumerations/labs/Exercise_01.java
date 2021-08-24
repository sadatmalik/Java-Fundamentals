package labs_examples.enumerations.labs;

/**
 * Enumerations Exercise 1:
 *
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a seperate class.
 *      2) Create a parameterized enumeration that passes one or more values to it's constructor. Demonstrate the use
 *      of this enum from a seperate class.
 */

enum Month {
    JANUARY("Still pretty dark out"),
    FEBRUARY("Shortest month of the year"),
    MARCH("Spring is here"),
    APRIL("Uh oh, April showers"),
    MAY("Happy birthday!"),
    JUNE("The sun has got his hat on!"),
    JULY("Longest day of the year"),
    AUGUST("Summer starts to slow"),
    SEPTEMBER("Getting cold again now"),
    OCTOBER("Cold and wet now"),
    NOVEMBER("A child is born!"),
    DECEMBER("Merry Christmas!");

    private String info;

    private Month(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Controller {

    public static void main(String[] args) {
        Month month = Month.JANUARY;
        System.out.println(month + "\n");

        for (Month m : Month.values()) {
            System.out.println(m + ": " + m.getInfo());
        }
    }
}
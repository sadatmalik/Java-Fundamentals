package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class BodyFat {

    private final double idealBodyFat;
    private final double currentBodyFat;

    public BodyFat(double idealBodyFat, double currentBodyFat) {
        this.idealBodyFat = idealBodyFat / 100;
        this.currentBodyFat = currentBodyFat / 100;
    }

    public double getIdealBodyFat() {
        return idealBodyFat;
    }

    public double getCurrentBodyFat() {
        return currentBodyFat;
    }
}

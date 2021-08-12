package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Calories {

    private Weight weight;
    private int[] maintenance;

    public Calories(Weight weight) {
        this.weight = weight;
        maintenance = null;
    }

    public int[] getMaintenance() {
        if (maintenance == null) {
            maintenance = new int[2];
            maintenance[0] = (int) (weight.getAverage() * Weight.POUNDS_PER_KILO * 13); // lower limit
            maintenance[1] = (int) (weight.getAverage() * Weight.POUNDS_PER_KILO * 17); // upper limit
        }
        return maintenance;
    }
}

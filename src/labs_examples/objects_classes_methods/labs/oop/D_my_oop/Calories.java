package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Calories {

    private Weight weight;
    private int[] maintenance;

    public final int MIFFLIN_ST_JOUR_MAINTENANCE = 2000;
    public final int GROUP_D_WEEKLY_SURPLUS = 1050;

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

    public int getWeightLossCalories(boolean useMifflinMethod) {
        if (useMifflinMethod) {
            return (int) (MIFFLIN_ST_JOUR_MAINTENANCE * 0.8);
        } else {
            return (int) (getMaintenance()[0] * 0.8);
        }
    }

    public int getWeightGainCalories(int numTrainingDays) {

        int gainCalories = MIFFLIN_ST_JOUR_MAINTENANCE + (GROUP_D_WEEKLY_SURPLUS / numTrainingDays);

        return gainCalories;
    }

    public Weight getWeight() {
        return weight;
    }
}

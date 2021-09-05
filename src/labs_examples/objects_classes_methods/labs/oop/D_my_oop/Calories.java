package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

// @todo : 14/08/2021
// Mifflin formula calculations
// Manual override for maintenance calorie levels

public class Calories {

    private Weight weight;
    private int maintenanceUpperThreshold;
    private int maintenanceLowerThreshold;
    private int maintenanceMifflinValue;

    public final int MIFFLIN_ST_JOUR_MAINTENANCE = 2000;
    public final int GROUP_D_WEEKLY_SURPLUS = 1050;

    public Calories(Weight weight) {
        this.weight = weight;
        maintenanceUpperThreshold = (int) (weight.getWeekAverage() * Weight.POUNDS_PER_KILO * 17); // upper limit
        maintenanceLowerThreshold = (int) (weight.getWeekAverage() * Weight.POUNDS_PER_KILO * 13); // lower limit

        // @todo hard-coded MSJ values, set them in code -- if user wants to use Mifflin
        MifflinStJeor msj = new MifflinStJeor(true, weight, 5, 11, 46,
                Activity.SEDENTARY);

        maintenanceMifflinValue = msj.getDailyCalories();
    }

    public int getMaintenanceUpperThreshold() {
        return maintenanceUpperThreshold;
    }

    public int getMaintenanceLowerThreshold() {
        return maintenanceLowerThreshold;
    }

    public int getMaintenanceMifflinValue() {
        return maintenanceMifflinValue;
    }

    public int getWeightLossCalories(Maintenance mode) {

        switch (mode) {
            case MIFFLIN:
                return (int) (getMaintenanceMifflinValue() * 0.8);

            default:
                return (int) (getMaintenanceLowerThreshold() * 0.8);
        }

    }

    public int getWeightGainCalories(boolean trainingDay, Split split, Maintenance mode) {

        int calories = 0;

        switch(mode) {
            case UPPER:
                if (trainingDay) {
                    calories = maintenanceUpperThreshold + (GROUP_D_WEEKLY_SURPLUS / split.getNumTrainingDays());
                } else {
                    calories = maintenanceUpperThreshold;
                }
                break;

            case LOWER:
                if (trainingDay) {
                    calories = maintenanceLowerThreshold + (GROUP_D_WEEKLY_SURPLUS / split.getNumTrainingDays());
                } else {
                    calories = maintenanceLowerThreshold;
                }
                break;

            case MIFFLIN:
                if (trainingDay) {
                    calories = maintenanceMifflinValue + (GROUP_D_WEEKLY_SURPLUS / split.getNumTrainingDays());
                } else {
                    calories = maintenanceMifflinValue;
                }
                break;
        }

        return calories;
    }

    public Weight getWeight() {
        return weight;
    }

}

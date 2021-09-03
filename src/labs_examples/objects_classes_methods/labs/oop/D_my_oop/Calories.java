package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

// @todo : 14/08/2021
// Mifflin formula and a Mifflin calculation mode selector
// Manual override for maintenance calorie levels

public class Calories {

    private Weight weight;
    private int maintenanceUpperThreshold;
    private int maintenanceLowerThreshold;
    private int maintenanceMifflinValue;

    private boolean mifflinMode;

    public final int MIFFLIN_ST_JOUR_MAINTENANCE = 2000;
    public final int GROUP_D_WEEKLY_SURPLUS = 1050;

    public Calories(Weight weight) {
        this.weight = weight;
        maintenanceUpperThreshold = (int) (weight.getWeekAverage() * Weight.POUNDS_PER_KILO * 17); // upper limit
        maintenanceLowerThreshold = (int) (weight.getWeekAverage() * Weight.POUNDS_PER_KILO * 13); // lower limit
        maintenanceMifflinValue = MIFFLIN_ST_JOUR_MAINTENANCE; // hard-coded value for now, will eventually use MSJ calculation
        mifflinMode = false;
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

    public int getWeightLossCalories(boolean useMifflinMethod) {
        if (useMifflinMethod) {
            return (int) (MIFFLIN_ST_JOUR_MAINTENANCE * 0.8);
        } else {
            return (int) (getMaintenanceLowerThreshold() * 0.8);
        }
    }

    public int getWeightGainCalories(boolean trainingDay, int numTrainingDays, Maintenance calculationMode) {

        int calories = 0;

        switch(calculationMode) {
            case UPPER:
                if (trainingDay) {
                    calories = maintenanceUpperThreshold + (GROUP_D_WEEKLY_SURPLUS / numTrainingDays);
                } else {
                    calories = maintenanceUpperThreshold;
                }

            case LOWER:
                if (trainingDay) {
                    calories = maintenanceLowerThreshold + (GROUP_D_WEEKLY_SURPLUS / numTrainingDays);
                } else {
                    calories = maintenanceLowerThreshold;
                }

            case MIFFLIN:
                if (trainingDay) {
                    calories = maintenanceMifflinValue + (GROUP_D_WEEKLY_SURPLUS / numTrainingDays);
                } else {
                    calories = maintenanceMifflinValue;
                }
        }

        return calories;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setMifflinMode(boolean mifflinMode) {
        this.mifflinMode = mifflinMode;
    }

    public boolean isMifflinMode() {
        return mifflinMode;
    }
}

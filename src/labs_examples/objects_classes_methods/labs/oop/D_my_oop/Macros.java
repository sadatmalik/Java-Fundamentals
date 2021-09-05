package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

// This is all defaulting to Mifflin calc at the moment
public class Macros {

    private int protein;
    private int trainingDayCarbs;
    private int trainingDayFat;
    private int restDayCarbs;
    private int restDayFat;

    private Calories cal;
    private final boolean gainCycle; // loss = false; gain = true

    private final static double PROTEIN_GRAMS_PER_POUND_BODY_WEIGHT = 1.0;
    private final static int CALORIES_PER_GRAM_OF_PROTEIN = 4;
    private final static int CALORIES_PER_GRAM_OF_FAT = 9;
    private final static int CALORIES_FROM_GRAM_OF_CARBS = 4;
    private final static double PERCENTAGE_CALORIES_FROM_FAT = 0.25;

    private final Split trainingSplit;
    

    public Macros(Calories cal, Maintenance mode, boolean gainCycle, Split trainingSplit) {
        this.cal = cal;
        this.gainCycle = gainCycle;
        this.trainingSplit = trainingSplit;

        // protein
        double idealWeightInPounds = cal.getWeight().getIdealWeightInPounds();
        protein = (int) (idealWeightInPounds * PROTEIN_GRAMS_PER_POUND_BODY_WEIGHT);

        // calculate loss/gain cycle fat and carbs
        if (!gainCycle) {
            int caloriesFromProtein = protein * CALORIES_PER_GRAM_OF_PROTEIN;
            int caloriesFromFat;

            caloriesFromFat = (int) (cal.getWeightLossCalories(mode) * PERCENTAGE_CALORIES_FROM_FAT);
            this.restDayFat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;
            this.trainingDayFat = this.restDayFat;

            int remainingCalories = cal.getWeightLossCalories(mode) - caloriesFromProtein - caloriesFromFat;
            this.restDayCarbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;
            this.trainingDayCarbs = this.restDayCarbs;

        } else {

            setFatAndCarbs(mode);
        }
    }

    private void setFatAndCarbs(Maintenance mode) {
        // maintenance calories
        int maintenanceCalories;

        // fat & carbs
        int caloriesFromProtein = protein * CALORIES_PER_GRAM_OF_PROTEIN;
        int caloriesFromFat;

        // Rest Day
        if (mode == Maintenance.MIFFLIN) {
            maintenanceCalories = cal.getMaintenanceMifflinValue();
        } else {
            maintenanceCalories = cal.getMaintenanceLowerThreshold();
        }
        caloriesFromFat = (int) (maintenanceCalories * trainingSplit.getRestDayFat());
        restDayFat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;

        int remainingCalories = maintenanceCalories - caloriesFromProtein - caloriesFromFat;
        restDayCarbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

        // Training Day
        int caloriesRequired;

        if (mode == Maintenance.MIFFLIN) {
            caloriesRequired = cal.getWeightGainCalories(true, trainingSplit.numTrainingDays, Maintenance.MIFFLIN);
        } else {
            caloriesRequired = cal.getWeightGainCalories(true, trainingSplit.numTrainingDays, Maintenance.LOWER);
        }
        caloriesFromFat = (int) (caloriesRequired * trainingSplit.getTrainingDayFat());
        trainingDayFat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;

        remainingCalories = caloriesRequired - caloriesFromProtein - caloriesFromFat;
        trainingDayCarbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

    }

    public int getProtein() {
        return protein;
    }

    public int getTrainingDayCarbs() {
        return trainingDayCarbs;
    }

    public int getTrainingDayFat() {
        return trainingDayFat;
    }

    public int getRestDayCarbs() {
        return restDayCarbs;
    }

    public int getRestDayFat() {
        return restDayFat;
    }

}

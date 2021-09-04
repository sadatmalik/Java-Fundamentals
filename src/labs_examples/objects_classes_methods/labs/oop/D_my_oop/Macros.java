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
    

    public Macros(Calories cal, boolean gainCycle, Split trainingSplit) {
        this.cal = cal;
        this.gainCycle = gainCycle;
        this.trainingSplit = trainingSplit;

        // protein
        double idealWeightInPounds = cal.getWeight().getIdealWeightInPounds();
        protein = (int) (idealWeightInPounds * PROTEIN_GRAMS_PER_POUND_BODY_WEIGHT);

    }

    private void setFatAndCarbs() {
        // fat & carbs
        int caloriesFromProtein = protein * CALORIES_PER_GRAM_OF_PROTEIN;
        int caloriesFromFat;

        if (!gainCycle) {
            // @TODO
//            caloriesFromFat = (int) (cal.getWeightLossCalories(false) * PERCENTAGE_CALORIES_FROM_FAT);
//            fat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;
//
//            int remainingCalories = cal.getWeightLossCalories(false) - caloriesFromProtein - caloriesFromFat;
//            carbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

        } else if (gainCycle) {
            // Rest Day
            caloriesFromFat = (int) (cal.getMaintenanceMifflinValue() * trainingSplit.getRestDayFat());
            restDayFat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;

            int remainingCalories = cal.getMaintenanceMifflinValue() - caloriesFromProtein - caloriesFromFat;
            restDayCarbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

            // Training Day
            int caloriesRequired = cal.getWeightGainCalories(true, trainingSplit.numTrainingDays, Maintenance.MIFFLIN);
            caloriesFromFat = (int) (caloriesRequired * trainingSplit.getTrainingDayFat());
            trainingDayFat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;

            remainingCalories = caloriesRequired - caloriesFromProtein - caloriesFromFat;
            trainingDayCarbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

        }

    }

    public int getProtein() {
        return protein;
    }

    public int getTrainingDayCarbs() {
        if (trainingDayCarbs == 0) {
            setFatAndCarbs();
        }
        return trainingDayCarbs;
    }

    public int getTrainingDayFat() {
        if (trainingDayFat == 0) {
            setFatAndCarbs();
        }
        return trainingDayFat;
    }

    public int getRestDayCarbs() {
        if (restDayCarbs == 0) {
            setFatAndCarbs();
        }
        return restDayCarbs;
    }

    public int getRestDayFat() {
        if (restDayFat == 0) {
            setFatAndCarbs();
        }
        return restDayFat;
    }


}

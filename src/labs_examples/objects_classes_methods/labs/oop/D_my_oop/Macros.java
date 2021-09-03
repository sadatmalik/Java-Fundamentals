package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

// This is all defaulting to Mifflin calc at the moment
public class Macros {

    private int protein;
    private int carbs;
    private int fat;

    private Calories cal;
    private final boolean gainCycle; // loss = false; gain = true

    private final double PROTEIN_GRAMS_PER_POUND_BODY_WEIGHT = 1.2;
    private final int CALORIES_PER_GRAM_OF_PROTEIN = 4;
    private final int CALORIES_PER_GRAM_OF_FAT = 9;
    private final int CALORIES_FROM_GRAM_OF_CARBS = 4;

    private final double PERCENTAGE_CALORIES_FROM_FAT = 0.25;
    private final double TRAINING_DAY_FAT_PERCENTAGE = 0.16;
    private final double REST_DAY_FAT_PERCENTAGE = 0.32;

    public Macros(Calories cal, boolean gainCycle, boolean trainingDay) {
        this.cal = cal;
        this.gainCycle = gainCycle;

        // protein
        double idealWeightInPounds = cal.getWeight().getIdealWeightInPounds();
        protein = (int) (idealWeightInPounds * PROTEIN_GRAMS_PER_POUND_BODY_WEIGHT);
        int caloriesFromProtein = protein * CALORIES_PER_GRAM_OF_PROTEIN;

        // fat & carbs
        int caloriesFromFat = 0;
        if (!gainCycle) {
            caloriesFromFat = (int) (cal.getWeightLossCalories(false) * PERCENTAGE_CALORIES_FROM_FAT);
            fat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;

            int remainingCalories = cal.getWeightLossCalories(false) - caloriesFromProtein - caloriesFromFat;
            carbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

        } else if (gainCycle && !trainingDay) {
            caloriesFromFat = (int) (cal.MIFFLIN_ST_JOUR_MAINTENANCE * REST_DAY_FAT_PERCENTAGE);
            fat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;

            int remainingCalories = cal.MIFFLIN_ST_JOUR_MAINTENANCE - caloriesFromProtein - caloriesFromFat;
            carbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

        } else if (gainCycle && trainingDay) {
            int caloriesRequired = cal.getWeightGainCalories(true, 4, Maintenance.MIFFLIN);
            caloriesFromFat = (int) (caloriesRequired * TRAINING_DAY_FAT_PERCENTAGE);
            fat = caloriesFromFat / CALORIES_PER_GRAM_OF_FAT;

            int remainingCalories = caloriesRequired - caloriesFromProtein - caloriesFromFat;
            carbs = remainingCalories / CALORIES_FROM_GRAM_OF_CARBS;

        }

    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }

}

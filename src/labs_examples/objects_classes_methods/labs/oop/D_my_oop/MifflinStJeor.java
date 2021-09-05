package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

/**
 * The Mifflin-St Jeor formula, created in the 1990s, provided an alternative and more valid estimate of RMR (3).
 *
 * The equations for males and females are:
 *
 * Men: (10 × weight in kg) + (6.25 × height in cm) - (5 × age in years) + 5
 * Women: (10 × weight in kg) + (6.25 × height in cm) - (5 × age in years) - 161
 *
 */
public class MifflinStJeor {

    boolean isMale;
    Weight weight;
    int heightInCm;
    int heightInFeet;
    int heightInInches;
    int ageInYears;
    Activity activityLevel;

    private static final double CENTIMETRES_PER_FOOT = 30.48;

    public MifflinStJeor(boolean isMale, Weight weight, int heightInFeet,
                         int heightInInches, int ageInYears, Activity activityLevel) {
        this.isMale = isMale;
        this.weight = weight;
        this.heightInFeet = heightInFeet;
        this.heightInInches = heightInInches;

        heightInCm = (int) ((heightInFeet + (heightInInches / 12d)) * CENTIMETRES_PER_FOOT);

        this.ageInYears = ageInYears;
        this.activityLevel = activityLevel;

    }

    public MifflinStJeor(boolean isMale, Weight weight, int heightInCm,
                         int ageInYears, Activity activityLevel) {
        this.isMale = isMale;
        this.weight = weight;
        this.heightInCm = heightInCm;

        // NB -- don't actually need feet and inches to be calculated for the calculations

        this.ageInYears = ageInYears;
        this.activityLevel = activityLevel;
    }

    /**
     * Men: (10 × weight in kg) + (6.25 × height in cm) - (5 × age in years) + 5
     * Women: (10 × weight in kg) + (6.25 × height in cm) - (5 × age in years) - 161
     *
     * @return RMR
     */
    public int getRestingMetabolicRate() {
        int rmr = (int) ((10 * weight.getWeekAverage()) + (6.25 * heightInCm) - (5 * ageInYears));;

        if (isMale) {
            rmr += 5;
        } else {
            rmr -= 161;
        }

        return rmr;
    }

    public int getDailyCalories() {
        return (int) (getRestingMetabolicRate() * activityLevel.getMultiplier());
    }

}

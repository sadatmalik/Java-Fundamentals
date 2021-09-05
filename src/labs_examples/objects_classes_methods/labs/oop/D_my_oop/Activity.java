package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

/**
 * Basic Activity Factor
 *
 * 1.2: If you are sedentary (little or no exercise) = BMR x 1.2
 * 1.375: If you are lightly active (light exercise/sports 1-3 days/week) = BMR x 1.375
 * 1.55: If you are moderately active (moderate exercise/sports 3-5 days/week) = BMR x 1.55
 * 1.725: If you are very active (hard exercise/sports 6-7 days a week) = BMR x 1.725
 * 1.9: If you are extra active (very hard exercise/sports & physical job or 2x training) = BMR x 1.9
 *
 */
public enum Activity {
    SEDENTARY(1.2),
    LIGHTLY_ACTIVE(1.375),
    MODERATELY_ACTIVE(1.55),
    VERY_ACTIVE(1.725),
    EXTRA_ACTIVE(1.9);

    private final double multiplier;

    private Activity(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}

package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Weight {

    public double startingWeight = 83.4; // kg

    public static final double POUNDS_PER_KILO = 2.205;
    private static final double MONTH_LOWER_TARGET_GAIN = 1 / POUNDS_PER_KILO;
    private static final double MONTH_UPPER_TARGET_GAIN = 1.5 / POUNDS_PER_KILO;

    private double[] week;
    private double average;
    private double upperThreshold;
    private double lowerThreshold;

    private BodyFat bodyFat;

    public BodyFat getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(BodyFat bodyFat) {
        this.bodyFat = bodyFat;
    }

    public Weight() {
        week = new double[7];
        average = 0;
        upperThreshold = 0;
        lowerThreshold = 0;
    }

    public double[] getWeek() {
        return week;
    }

    public double getWeekAverage() {
        if (average == 0) {
            double sum = 0;
            for (double d : week) {
                sum += d;
            }

            average = sum / 7d;
        }
        return average;
    }

    public double getUpperThreshold() {
        if (upperThreshold == 0) {
            upperThreshold = average + (MONTH_UPPER_TARGET_GAIN * 12 / 52);
        }
        return upperThreshold;
    }

    public double getLowerThreshold() {
        if (lowerThreshold == 0) {
            lowerThreshold = average + (MONTH_LOWER_TARGET_GAIN * 12 / 52);
        }
        return lowerThreshold;
    }

    public double getIdealWeightInKg() {
        return startingWeight * (1 - (bodyFat.getCurrentBodyFat() - bodyFat.getIdealBodyFat()));
    }

    public double getIdealWeightInPounds() {
        return startingWeight * POUNDS_PER_KILO * (1 - (bodyFat.getCurrentBodyFat() - bodyFat.getIdealBodyFat()));
    }

}

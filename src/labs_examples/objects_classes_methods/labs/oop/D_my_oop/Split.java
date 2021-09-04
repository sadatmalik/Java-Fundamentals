package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public enum Split {
    THREE_DAY(3,0.32, 0.16),
    FOUR_DAY(4,0.32, 0.2);

    int numTrainingDays;
    double restDayFat;
    double trainingDayFat;

    private Split(int numTrainingDays, double restDayFat, double trainingDayFat) {
        this.numTrainingDays = numTrainingDays;
        this.restDayFat = restDayFat;
        this.trainingDayFat = trainingDayFat;
    }

    public int getNumTrainingDays() {
        return numTrainingDays;
    }

    public double getRestDayFat() {
        return restDayFat;
    }

    public double getTrainingDayFat() {
        return trainingDayFat;
    }
}

package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Weight weight = new Weight();
        double[] week = weight.getWeek();

        // Populate a week's weights
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            System.out.print("Input weight for day " + i + ": ");
            week[i] = scanner.nextDouble();
        }

        // Get average for week and next week's target range
        double average = weight.getWeekAverage();
        double upper = weight.getUpperThreshold();
        double lower = weight.getLowerThreshold();

        System.out.println("\n---------------Weight average and next week's target range---------------");

        System.out.printf("Average current weight = %.2f \n", average);
        System.out.printf("Upper target limit for next week = %.2f \n", upper);
        System.out.printf("Lower target limit for next week = %.2f \n", lower);

        // Get maintenance calories
        Calories cal = new Calories(weight);
        System.out.println("\n---------------Maintenance calorie levels---------------");
        System.out.println("Upper Threshold (weight in pounds * 17) = " + cal.getMaintenanceUpperThreshold());
        System.out.println("Lower Threshold (weight in pounds * 13) = " + cal.getMaintenanceLowerThreshold());
        System.out.println("Using Mifflin-St Jeor calculation  = " + cal.getMaintenanceMifflinValue());

        // Set ideal and current body fat percentages
        System.out.println("\n---------------Body Fat and Ideal Weight---------------");
        BodyFat fat = new BodyFat(10d, 20d);
        weight.setBodyFat(fat);
        System.out.println("Starting body fat = " + fat.getCurrentBodyFat()
                + ", Starting weight = " + weight.startingWeight);

        // Get ideal weight
        System.out.println("Ideal body fat = " + fat.getIdealBodyFat()
                        + ", Ideal weight = " + weight.getIdealWeightInKg());

        // Get weight gain cycle calories and macros for 3 and 4 training days per week:
        System.out.println("\n---------------Target Calories / Macros for Muscle Gain cycle---------------");
        printGainCycleCaloriesAndMacros(cal, Split.FOUR_DAY);
        printGainCycleCaloriesAndMacros(cal, Split.THREE_DAY);

        // Get weight loss cycle calories and macros:
        System.out.println("\n---------------Target Calories / Macros for Fat Loss cycle---------------");
        printLossCycleCaloriesAndMacros(cal, Maintenance.LOWER);
    }

    private static void printLossCycleCaloriesAndMacros(Calories cal, Maintenance mode) {
        Macros macros = new Macros(cal, mode, false, null);

        System.out.println("\nDaily calories = " + cal.getWeightLossCalories(mode));
        System.out.println("Daily protein = " + macros.getProtein() + "g");
        System.out.println("Daily fat = " + macros.getRestDayFat() + "g");
        System.out.println("Daily carbs = " + macros.getRestDayCarbs() + "g");

    }

    private static void printGainCycleCaloriesAndMacros(Calories cal, Split split) {
        System.out.println("\n" + split.getNumTrainingDays() + " day training split:");

        // Weight gain macros
        Macros macros = new Macros(cal, Maintenance.MIFFLIN, true, split);
        int trainingDayCalories = cal.getWeightGainCalories(true, split.getNumTrainingDays(), Maintenance.MIFFLIN);

        System.out.println("\nTraining day calories = " + trainingDayCalories);
        System.out.println("Training day protein = " + macros.getProtein() + "g");
        System.out.println("Training day fat = " + macros.getTrainingDayFat() + "g");
        System.out.println("Training day carbs = " + macros.getTrainingDayCarbs() + "g");

        System.out.println("\nRest day calories = " + cal.getMaintenanceMifflinValue());
        System.out.println("Rest day protein = " + macros.getProtein() + "g");
        System.out.println("Rest day fat = " + macros.getRestDayFat() + "g");
        System.out.println("Rest day carbs = " + macros.getRestDayCarbs() + "g");

    }


}

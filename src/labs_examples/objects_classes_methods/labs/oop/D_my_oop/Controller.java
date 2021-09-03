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

        // Get ideal weight
        System.out.println("Ideal weight = " + weight.getIdealWeightInKg());

        // Get weight gain calories for 3 and 4 training days per week:
        System.out.println("\n---------------Target Calories for Muscle Gain cycle---------------");

        System.out.println("Training day calories for 4 workout days per week = "
                + cal.getWeightGainCalories(true,4, Maintenance.MIFFLIN));

        System.out.println("Training day calories for 3 workout days per week = "
                + cal.getWeightGainCalories(true,3, Maintenance.MIFFLIN));

        System.out.println("Calories for rest day = " + cal.getMaintenanceMifflinValue());


        System.out.println("\n@TODO pick up from here ---------------Target Calories for Weight Loss cycle---------------");
        // Weight loss cycle macros
        Macros macros = new Macros(cal, false, false);
        System.out.println("Weight loss cycle daily protein = " + macros.getProtein() + "g");
        System.out.println("Weight loss cycle daily fat = " + macros.getFat() + "g");
        System.out.println("Weight loss cycle daily carbs = " + macros.getCarbs() + "g");

        // Weight gain cycle
        macros = new Macros(cal, true, false);
        System.out.println("Weight gain cycle rest day protein = " + macros.getProtein() + "g");
        System.out.println("Weight gain cycle rest day fat = " + macros.getFat() + "g");
        System.out.println("Weight gain cycle rest day carbs = " + macros.getCarbs() + "g");

        macros = new Macros(cal, true, true);
        System.out.println("Weight gain cycle training day protein = " + macros.getProtein() + "g");
        System.out.println("Weight gain cycle training day fat = " + macros.getFat() + "g");
        System.out.println("Weight gain cycle training day carbs = " + macros.getCarbs() + "g");


    }


}

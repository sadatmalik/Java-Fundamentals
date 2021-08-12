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
        double average = weight.getAverage();
        double upper = weight.getUpperThreshold();
        double lower = weight.getLowerThreshold();

        System.out.println("Average current weight = " + average);
        System.out.println("Upper target limit for next week = " + upper);
        System.out.println("Lower target limit for next week = " + lower);

        // Get maintenance calories
        Calories cal = new Calories(weight);
        System.out.println("Maintenance calories = " + cal.getMaintenance()[0] + " / " + cal.getMaintenance()[1]);

        // Set ideal and current body fat percentages
        BodyFat fat = new BodyFat(10d, 20d);
        weight.setBodyFat(fat);

        // Get ideal weight
        System.out.println("Ideal weight = " + weight.getIdealWeightInKg());

        // Get weight gain calories for 3 and 4 training days per week:
        System.out.println("Training day calories for 3 workout days per week = " + cal.getWeightGainCalories(3));
        System.out.println("Training day calories for 4 workout days per week = " + cal.getWeightGainCalories(4));
        System.out.println("Non training day calories = " + cal.MIFFLIN_ST_JOUR_MAINTENANCE);

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

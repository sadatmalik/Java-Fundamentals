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

        // Get ideal weight
        System.out.println("Ideal weight = " + fat.getIdealWeight(weight));
    }


}

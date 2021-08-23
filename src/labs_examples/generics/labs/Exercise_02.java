package labs_examples.generics.labs;

/**
 * Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList. Demonstrate how to call this method from the main() method.
 */
import java.util.ArrayList;

class Demo {

    public static double sumArray(ArrayList<? extends Number> array) {

        double d = 0;
        for (Number number : array) {
            d += number.doubleValue();
        }
        return d;
    }

    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(2.3);
        doubles.add(4.5);
        doubles.add(3.2);
        System.out.println(sumArray(doubles));
    }
}
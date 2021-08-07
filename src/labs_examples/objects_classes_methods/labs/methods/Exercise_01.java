package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {

        // please create the methods as instructed below then
        // call each of those methods from here, within the main()
        System.out.println("3 * 4 = " + multiply(3, 4));
        System.out.println("12 / 6 = " + divide(12, 6));
        joke();
        System.out.println(yearToSeconds(3) + " seconds in 3 years");
        System.out.println(argsLength("Sadat", "Malik", "was", "here!") + " = length of varargs");

    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b
    public static int multiply(int a, int b) {
        return a * b;
    }


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b
    public static int divide(int a, int b) {
        return a / b;
    }


    // 3) Create a static void method that will print of joke of your choice to the console
    public static void joke() {
        System.out.println("An Englishman, Scotsman, and Irishman walk into a bar. " +
                "The barman says 'Is this some kind of joke?'");
    }


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents
    public static int yearToSeconds(int year) {
        return year * 365 * 24 * 60 * 60;
    }


    // 5) Create a varargs method that will return the length of the varargs array passed in
    public static int argsLength(String... args) {
        return args.length;
    }

}

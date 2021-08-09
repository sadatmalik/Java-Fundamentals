package labs_examples.objects_classes_methods.labs.methods;

import java.util.ArrayList;
import java.util.Locale;

public class MethodTraining {

    public static void main(String[] args) {
        // overloading
        System.out.println("--overloading");
        System.out.println("2 * 3 = " + multiply(2, 3));
        System.out.println("2d * 3d = " + multiply(2d, 3d));
        System.out.println("2 * 3 * 4 = " + multiply(2, 3, 4));

        // pass by value
        System.out.println("\n--pass by value");
        int a = 1;
        int b = 2;

        System.out.println("before a: = " + a);
        System.out.println("before b: = " + a);

        multiply(a, b);

        System.out.println("after a: = " + a);
        System.out.println("after b: = " + a);

        // pass by reference
        System.out.println("\n--pass by value");
        Person p = new Person("John", 47);

        System.out.println("Before p = " + p);
        addYearToAge(p);
        System.out.println("After p = " + p);

        // Largest of 4 numbers
        System.out.println("\n--largest of 4, 30, 6, 16");
        System.out.println(greatest(4, 30, 6, 16));

        // Consonants
        System.out.print("\n--consonants in Sadat Malik was here! = ");
        int n = numConsonants("Sadat Malik was here!");
        System.out.println(n);

        // Primes
        System.out.println("\n--primes");
        System.out.print("First 10 primes: ");
        int count = 0;
        int i = 2;
        while (count < 10) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }

        // Min / Max
        System.out.println("\n--min/max");
        System.out.print("Min and Max from 4 30 6 16 : ");
        int[] minMax = getMinMax(new int[] {4, 30, 6, 16});
        System.out.println(minMax[0] + " " + minMax[1]);


    }

    //     1) Demonstrate method overloading in this class
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(double a, double b) {
        return (int) (a * b);
    }

    public static int multiply(int... nums) {
        int total = 1;
        for (int i : nums) {
            total *= i;
        }
        return total;
    }

    //     2) Demonstrate the difference between "pass by value" and "pass by reference"
    public static void addYearToAge(Person p) {
        p.age++;
    }

    //    3) Create a method that will return the largest of 4 numbers (all of which are passed in as arguments)
    public static int greatest(int... args) {
        if (args.length == 1) {
            return args[0];
        }

        int[] temp = new int[args.length-1];
        for (int i = 1; i < args.length; i++) {
            temp[i-1] = args[i];
        }

        int greatestRem = greatest(temp);
        return args[0] > greatestRem ? args[0] : greatestRem;
    }

    //    4) Write a method to count all consonants (the opposite of vowels) in a String
    public static int numConsonants(String s) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        char[] chars = s.toCharArray();

        int count = 0;
        for (char c : chars) {
            if (consonants.contains(Character.toString(c).toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    //     5) Write a method that will determine whether or not a number is prime
    public static boolean isPrime(int n) {
        // a prime number is only divisible by itself and 1
        boolean isPrime = true;
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    //    6) Write a method that will return a small array containing the highest and lowest numbers in a
    //    given numeric array, which is passed in as an argument
    public static int[] getMinMax(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // int[] minMax = {min, max};
        return new int[] {min, max};
    }

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
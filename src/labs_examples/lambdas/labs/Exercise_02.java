package labs_examples.lambdas.labs;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */

class JavaUtilFunctionsDemo {

    public static void main(String[] args) {

        // Consumer
        Consumer<String> hello = (s) -> System.out.println("Hello," + s);
        hello.accept("Sadat");

        Consumer<String> greeting = (s) -> System.out.println("Welcome to " + s + "'s mansion!");
        hello.andThen(greeting).accept("John");

        // Supplier
        Supplier<Long> random = () -> Long.valueOf(new Random().nextLong());
        long l = random.get();
        System.out.println("\nGet from Supplier<Long> : " + l);

        // Function
        Function<String, Integer> funcStringToInt = (s) -> Integer.parseInt(s);
        Function<Integer, Integer> funcTimesTwo = (i) -> i * 2;
        Function<Integer, String> funcIntToString = (i) -> String.valueOf(i);
        Function<String, String> funcToUpperCase = (s) -> s.toUpperCase();

        int a = funcTimesTwo.compose(funcStringToInt).apply("1");
        System.out.println("\n" + a);

        String x = funcIntToString.andThen(funcToUpperCase).apply(4);
        System.out.println(x);


        // Predicate
        Predicate<String> lessThan32 = (s) -> s.length() < 32;
        System.out.println("\n" + lessThan32.test("Is this string less than 32 characters?"));
        System.out.println(lessThan32.negate().test("Is this string less than 32 characters?"));

        Predicate<String> greaterThan4 = (s) -> s.length() > 4;
        System.out.println(lessThan32.and(greaterThan4).test("> 4 && < 32 ?"));



    }


}
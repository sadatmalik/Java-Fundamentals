package labs_examples.lambdas.labs;

import java.util.Random;
import java.util.function.*;

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

        // BiConsumer
        BiConsumer<String, Integer> printNum = (s, i) -> {
            for (int x = 0; x < i; x++) {
                System.out.println(s);
            }
        };
        printNum.accept("Hi", 3);

        // Supplier
        Supplier<Long> random = () -> Long.valueOf(new Random().nextLong());
        long l = random.get();
        System.out.println("\nGet from Supplier<Long> : " + l);

        // BooleanSupplier
        BooleanSupplier truth = () -> true;
        System.out.println("\nBooleanSupplier.getAsBoolean() returns : " + truth.getAsBoolean());

        // Function
        Function<String, Integer> funcStringToInt = (s) -> Integer.parseInt(s);
        Function<Integer, Integer> funcTimesTwo = (i) -> i * 2;
        Function<Integer, String> funcIntToString = (i) -> String.valueOf(i);
        Function<String, String> funcToUpperCase = (s) -> s.toUpperCase();

        int a = funcTimesTwo.compose(funcStringToInt).apply("1");
        System.out.println("\n" + a);

        String x = funcIntToString.andThen(funcToUpperCase).apply(4);
        System.out.println(x);

        // BiFunction
        BiFunction<String, Integer, String> biFunc = (s, i) -> {
            String ret = "";
            for (int y = 0; y < i; y++) {
                ret += s + " ";
            }
            return ret;
        };
        String biFuncReturn = biFunc.apply("Hello", 3);
        System.out.println("\n" + biFuncReturn);


        // Predicate
        Predicate<String> lessThan32 = (s) -> s.length() < 32;
        System.out.println("\n" + lessThan32.test("Is this string less than 32 characters?"));
        System.out.println(lessThan32.negate().test("Is this string less than 32 characters?"));

        Predicate<String> greaterThan4 = (s) -> s.length() > 4;
        System.out.println(lessThan32.and(greaterThan4).test("> 4 && < 32 ?"));

        // BiPredicate
        BiPredicate<Integer, Integer> equals = (i1, i2) -> i1 == i2;
        System.out.println("\n2 == 2 ? " + equals.test(2, 2));

        // Unary Operator (extends Function)
        UnaryOperator<String> helloName = (s) -> "Hello, " + s;
        String s2 = helloName.apply("Sadat");
        System.out.println("\n" + s2);

        // Binary Operator (extends BiFunction)
        BinaryOperator<String> concat = (s, t) -> s + " " + t;
        String s3 = concat.apply("Hello", "again!");
        System.out.println(s3);

    }


}
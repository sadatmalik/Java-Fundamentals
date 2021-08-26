package labs_examples.lambdas.labs;

import java.util.function.Function;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */

class JavaUtilFunctionsDemo {

    public static void main(String[] args) {

        Function<String, Integer> funcStringToInt = (s) -> Integer.parseInt(s);
        Function<Integer, Integer> funcTimesTwo = (i) -> i * 2;
        Function<Integer, String> funcIntToString = (i) -> String.valueOf(i);
        Function<String, String> funcToUpperCase = (s) -> s.toUpperCase();

        int i = funcTimesTwo.compose(funcStringToInt).apply("1");
        System.out.println(i);

        String s = funcIntToString.andThen(funcToUpperCase).apply(4);
        System.out.println(s);
    }


}
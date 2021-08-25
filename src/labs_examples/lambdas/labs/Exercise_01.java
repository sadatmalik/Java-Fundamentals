package labs_examples.lambdas.labs;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 *
 *
 *
 *
 */

@FunctionalInterface
interface FuncInterface {
    void method();
}

@FunctionalInterface
interface FuncInterfaceSingleParam<T> {
    public T method(T s);
}

@FunctionalInterface
interface FuncInterfaceTwoParameters<T, S, R> {
    public R method(T t, S s);
}

class FuncInterfaceDemo {
    public static void main(String[] args) {

        // No params functional interface
        FuncInterface lambda = () -> {
            System.out.println("Hello from lambda");
        };
        lambda.method();

        FuncInterface anonClass = new FuncInterface() {
            @Override
            public void method() {
                System.out.println("Hello from anon inner class");
            }
        };
        anonClass.method();


        // Single param functional interface
        FuncInterfaceSingleParam<String> lambda2 = (s) -> {
            return s;
        };
        lambda2.method("Sadat");

        FuncInterfaceSingleParam<String> anon2 = new FuncInterfaceSingleParam<>() {
            @Override
            public String method(String s) {
                return s;
            }
        };
        anon2.method("Sadat again");

        // Double parameter functional interface
        FuncInterfaceTwoParameters<String, Integer, Boolean> lambda3 = (s, i) -> {
          return s.length() < i;
        };
        System.out.println(lambda3.method("Sadat", 6));

        FuncInterfaceTwoParameters<String, Integer, Boolean> anon3 = new FuncInterfaceTwoParameters<>() {
            @Override
            public Boolean method(String s, Integer i) {
                return s.length() < i;
            }
        };
        System.out.println(anon3.method("Sadat", 3));


        // java.util.function.BiFunction
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> {
          return a * b;
        };
        Function<Integer, Integer> half = (a) -> {
            return a / 2;
        };
        System.out.println(multiply.andThen(half).apply(2, 5));;


        // java.util.function.Consumer
        Consumer<String> upper = (s) -> System.out.println(s.toUpperCase());
        Consumer<String> asCharArray = (s) -> System.out.println(Arrays.toString(s.toCharArray()));

        upper.andThen(asCharArray).accept("Sadat");

    }
}
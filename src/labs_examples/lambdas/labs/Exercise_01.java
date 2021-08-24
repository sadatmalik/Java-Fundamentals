package labs_examples.lambdas.labs;

/**
 * Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 * @TODO
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

class FuncInterfaceDemo {
    public static void main(String[] args) {
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
    }
}
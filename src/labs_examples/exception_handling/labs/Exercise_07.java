package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 7:
 *
 *      1) Create a custom exception.
 *      2) Demonstrate a method throwing your custom exception.
 */
class CustomException extends Exception {

    @Override
    public String toString() {
        return "CustomException{My Custom Exception}";
    }
}

class Main {

    public static void main(String[] args) {

        try {
            customMethod();
        } catch (CustomException ce) {
            ce.printStackTrace();
        }
    }

    public static void customMethod() throws CustomException {
        throw new CustomException();
    }
}
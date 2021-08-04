package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all logical operators below. These include:
 *
 * AND, short-circuit AND, OR, short-circuit OR, XOR, NOT
 *
 */
class LogicalOperators {

    public static void main(String[] args) {

        // example of "OR"
        boolean a = true;
        boolean b = false;
        if (a | b){
            System.out.println("#1 a or b is true");
        }

        // write your code below
        // example of short-circuit OR
        if (a || b) {
            System.out.println("#2 a or b is true");
        }

        // AND
        boolean c = true;
        if (a & c) {
            System.out.println("#3 a and c are true");
        }

        // short-circuit AND
        if (a && c) {
            System.out.println("#4 a and c are true");
        }

        // XOR
        if (a ^ b) {
            System.out.println("#5 a or b is true but not both");
        }

        // NOT
        if (!b) {
            System.out.println("#6 b is not true");
        }

    }

}


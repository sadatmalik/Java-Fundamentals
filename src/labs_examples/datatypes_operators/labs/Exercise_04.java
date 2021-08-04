package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all relational operators below. These include:
 *
 * less than, less than or equal to, greater than, greater than or equal to, and equal to
 *
 */
class RelationalOperators {

    public static void main(String[] args) {

        // example of "less than"
        int a = 1;
        int b = 2;
        if (a < b){
            System.out.println("#1 a is less than b");
        }

        // write your code below
        // less than or equal to
        if (a <= b) {
            System.out.println("#2 a is less than or equal to b");
        }

        // greater than
        if (b > a) {
            System.out.println("#3 b is greater than a");
        }

        // greater than or equal to
        if (b >= a) {
            System.out.println("#4 b is greater than or equal to a");
        }

        // equal to
        if (a == a) {
            System.out.println("#5 a is equal to a");
        }

        // not equal to
        if (a != b) {
            System.out.println("#6 a is not equal to b");
        }
    }

}


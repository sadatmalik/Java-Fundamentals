package labs_examples.generics.labs;

/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

class GenericClassDemo {

    public static void main(String[] args) {
        GenericClass<String, Integer> gen = new GenericClass<>("Sadat", 3);
        System.out.println(gen.getT() + " " + gen.getS());

        GenericClass<Double, Boolean> gen2 = new GenericClass<>(3.4, false);
        System.out.println(gen2.getT() + " " + gen2.getS());

        gen.setT("John");
        System.out.println(gen.getT() + " " + gen.getS());

    }
}

class GenericClass<T, S> {

    T t;
    S s;

    public GenericClass(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public T getT() {
        return t;
    }

    public S getS() {
        return s;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setS(S s) {
        this.s = s;
    }
}
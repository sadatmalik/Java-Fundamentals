package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class OverloadingDemo {

    public static void main(String[] args) {
        print("Sadat");
        print(1);
        print(32.3);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print(double d) {
        System.out.println(d);
    }
}

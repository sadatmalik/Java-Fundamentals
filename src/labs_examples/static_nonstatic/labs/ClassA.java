package labs_examples.static_nonstatic.labs;

public class ClassA {

    public static void main(String[] args) {
        // 1) A static method calling another static method in the same class
        staticMethodA();

        // 2) A static method calling a non-static method in the same class
        ClassA obj = new ClassA();
        obj.nonstaticMethodA();

        // 3) A static method calling a static method in another class
        ClassB.staticMethodA();

        // 4) A static method calling a non-static method in another class
        ClassB obj2 = new ClassB();
        obj2.nonstaticMethodA();

        // 5) A non-static method calling a non-static method in the same class
        obj.nonstaticMethodB();

        //6) A non-static method calling a non-static method in another class
        obj.nonstaticMethodC();

        //7) A non-static method calling a static method in the same class
        obj.nonstaticMethodD();

        //8) A non-static method calling a static method in another class
        obj.nonstaticMethodE();
    }


    public static void staticMethodA() {
        staticMethodB();
    }

    public static void staticMethodB() {
        System.out.println("Calling non static methodB");
    }

    public void nonstaticMethodA() {
        System.out.println("Non static method A called");
    }

    public void nonstaticMethodB() {
        nonstaticMethodA();
    }

    public void nonstaticMethodC() {
        ClassB obj = new ClassB();
        obj.nonstaticMethodA();
    }

    public void nonstaticMethodD() {
        staticMethodB();
    }

    public void nonstaticMethodE() {
        ClassB.staticMethodA();
    }
}

package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

/**
 * Why does the output print in the order it does?
 *
 * You answer: The parent must exist before the child. Therefore C_1's parent (B_1) must exist before C_1.
 * And B_1's parent (A_1) must exist before B_2. C_1's constructor has an implicit call to super() which calls
 * B_1's constructor.  B_1's constructor has an implicit super() call to A_1's constructor. A_1's constructor
 * prints "Class A Constructor" and then returns execution flow to B_1's constructor which prints
 * "Class B Constructor" and then returns flow of execution back to C_1's constructor which prints
 * "Class A Constructor".
 *
 */

class A_1 {
    public A_1()
    {
        System.out.println("Class A Constructor");
    }
}

class B_1 extends A_1 {
    public B_1()
    {
        System.out.println("Class B Constructor");
    }
}

class C_1 extends B_1 {
    public C_1()
    {
        System.out.println("Class C Constructor");
    }
}

public class Exercise_03 {
    public static void main(String[] args)
    {
        C_1 c = new C_1();
    }
}

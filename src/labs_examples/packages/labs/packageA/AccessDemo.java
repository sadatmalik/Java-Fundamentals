package labs_examples.packages.labs.packageA;

import labs_examples.packages.labs.packageB.ClassB;

public class AccessDemo {

    public static void main(String[] args) {
        ClassA classA = new ClassA();

        // public method ok from anywhere
        classA.publicMethod();

        // protected method ok in same package
        classA.protectedMethod();

        // default method ok in same package
        classA.defaultMethod();

        // private method not visible outside of class
        //: classA.privateMethod():

        ClassB classB = new ClassB();
        // public method ok from anywhere
        classB.publicMethod();

        // protected method not visible outside of package (unless subclassed)
        //: classB.protectedMethod();

        // default method not visible outside of package
        //: classB.defaultMethod();

        // private method not visible outside of class
        //: classA.privateMethod():


        // test subclassing
        ClassC classC = new ClassC();

        // protected method ok in subclass
        classC.protectedMethod();

        // default method ok in same package
        classC.defaultMethod();


        // test subclassing
        ClassD classD = new ClassD();

        // protected method ok in subclass (visible for @Override)
        classD.protectedMethod();

        // default method not visible outside of package
        //: classD.defaultMethod();



    }
}

class ClassC extends ClassA {

}

class ClassD extends ClassB {

    @Override //: protected method in ClassB available for override from different package
    protected void protectedMethod() {
        super.protectedMethod();
    }
}
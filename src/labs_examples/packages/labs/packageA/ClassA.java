package labs_examples.packages.labs.packageA;

public class ClassA {

    public void publicMethod() {
        System.out.println("PackageA ClassA public method called");
    }

    protected void protectedMethod() {
        System.out.println("PackageA ClassA protected method called");
    }

    void defaultMethod() {
        System.out.println("PackageA ClassA default method called");
    }

    private void privateMethod() {
        System.out.println("PackageA ClassA private method called");
    }

}

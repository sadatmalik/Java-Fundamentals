package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class InterfacePolymorphismDemo {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeNoise();
        cat.makeNoise();
    }

}

interface Animal {
    public void makeNoise();
}

class Dog implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("Bark");
    }
}

class Cat implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("Meow");
    }
}
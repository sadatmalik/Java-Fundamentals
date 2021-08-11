package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class OverridingDemo {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle moto = new Motorbike();

        vehicle.accelerate();
        moto.accelerate();
    }
}

class Vehicle {
    public void accelerate() {
        System.out.println("Vehicle accelerating");
    }
}

class Motorbike extends Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Motorbike accelerating");
    }
}

package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Apple extends Fruit {

    public Apple(String name, double fibre) {
        super(name, fibre);
    }

    public Apple(String name, double calories, double protein, double carbs, double fat, double fibre) {
        super(name, calories, protein, carbs, fat, fibre);
    }

    @Override
    public boolean eat() {
        System.out.println("Eat apple");
        return true;
    }
}

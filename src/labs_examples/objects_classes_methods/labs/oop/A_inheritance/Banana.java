package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Banana extends Fruit {

    public Banana(String name, double calories, double protein, double carbs, double fat, double fibre) {
        super(name, calories, protein, carbs, fat, fibre);
    }

    @Override
    public boolean eat() {
        System.out.println("Eat banana");
        return true;
    }
}

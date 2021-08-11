package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Kiwi extends Fruit {

    public Kiwi(String name, double calories, double protein, double carbs, double fat, double fibre) {
        super(name, calories, protein, carbs, fat, fibre);
    }

    @Override
    public boolean eat() {
        System.out.println("Eat Kiwi");
        return true;
    }
}

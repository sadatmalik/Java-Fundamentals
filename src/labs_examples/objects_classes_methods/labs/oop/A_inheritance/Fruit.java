package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Fruit extends Food {

    double fibre;

    public Fruit(String name, double fibre) {
        super(name);
        this.fibre = fibre;
    }

    public Fruit(String name, double calories, double fibre) {
        super(name, calories);
        this.fibre = fibre;
    }

    public Fruit(String name, double calories, double protein, double carbs, double fat, double fibre) {
        super(name, calories, protein, carbs, fat);
        this.fibre = fibre;
    }

    @Override
    public boolean eat() {
        System.out.println("Eat fruit");
        return true;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

}

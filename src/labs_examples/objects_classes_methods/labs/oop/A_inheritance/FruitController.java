package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class FruitController {

    public static void main(String[] args) {
        Fruit banana = new Banana("Banana", 125, 5, 32, 0.1, 5);
        System.out.println(banana.eat());

        System.out.println(banana.getFibre());
        System.out.println(banana.getCalories());
    }

}

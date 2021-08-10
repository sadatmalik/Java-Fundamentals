package labs_examples.objects_classes_methods.labs.objects;

// For this exercise please create two classes. The first class is the controller and it will contain the main() method.
// The second class is a POJO. Just a simple object type class that defines an object. In this POJO, demonstrate
// at least three overloaded constructors. In the main() method, create at least 3 objects of your POJO class, each using
// a different constructor.


// Controller
public class ConstructorOverloadingExample {

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        System.out.println(fruit.toString());

        Fruit banana = new Fruit("Banana");
        System.out.println(banana.toString());

        Fruit greenApple = new Fruit("Apple", "Green");
        System.out.println(greenApple.toString());
    }
}


// POJO
class Fruit {
    private String name;
    private String colour;

    public Fruit() {};

    public Fruit(String name) {
        this.name = name;
    }

    public Fruit(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
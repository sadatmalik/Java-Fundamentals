package labs_examples.objects_classes_methods.labs.objects;

// Please demonstrate Object association by creating at least two POJOs and a Controller class. The Controller
// class will contain the main() method. In the main() create an object of each POJO you just created and associate
// the two together. (This is easier than it sounds. Refer to the Object Association documentation if you're not sure.)

class PersonController {

    public static void main(String[] args) {
        Person person = new Person("Jane", 25);
        Bag bag = new Bag("LV", "Brown");

        System.out.println(person.getName() + " has a " + bag.getBrand() + " bag.");
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Bag {
    private String brand;
    private String colour;

    public Bag(String brand, String colour) {
        this.brand = brand;
        this.colour = colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
package labs_examples.lambdas.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Lambdas Exercise 3:
 *
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 *
 */

class Demo {

    int counter;

    public static void main(String[] args) {
        String timer = "Tick-tock";

        // 1) Demonstrate the use of a static method reference
        List<String> myList = new ArrayList<>(List.of("one", "two", "three"));
        myList.stream().forEach(System.out::println);

        // 2) Demonstrate the use of an instance method reference
        Demo demo = new Demo();
        Thread t = new Thread(demo::countDown);
        t.start();

        try {
            t.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        // 3) Demonstrate the use of a constructor reference
        Function<Integer, Demo> getDemo = Demo::new;
        demo = getDemo.apply(10);
        demo.countDown();

    }

    public Demo() {
        counter = 5;
    }

    public Demo(int counter) {
        this.counter = counter;
    }

    public void countDown() {
        for (int i = 1; i <= counter; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
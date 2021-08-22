package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("I am running in - " + Thread.currentThread().getName());
    }
}

class Application {

    public static void main(String[] args) {

        // Can initiate like this:
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable, "Runnable1");
        thread1.start();

        // Or another way, as don't need to keep any references
        new Thread(new MyRunnable(), "Runnable2").start();

    }
}
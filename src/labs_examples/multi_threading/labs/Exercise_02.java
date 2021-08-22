package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */

class MyThread extends Thread {

    public MyThread(String name) {
        setName(name);
        start();
    }

    @Override
    public void run() {
        System.out.println("Running in " + getName());
    }

}

class Application2 {

    public static void main(String[] args) {

        new MyThread("MyThread1");
        new MyThread("MyThread2");
        new MyThread("MyThread3");
    }
}
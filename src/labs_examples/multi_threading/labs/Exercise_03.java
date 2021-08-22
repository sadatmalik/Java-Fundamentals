package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 3:
 *
 *      In one of the previous exercises, demonstrate changing the priority of a thread
 */

class MyThreadWithPriority extends Thread {

    public MyThreadWithPriority(String name, int priority) {
        setName(name);
        setPriority(priority);
        start();
    }

    @Override
    public void run() {
        System.out.println("Running in " + getName());
    }

}

class Application3 {

    public static void main(String[] args) {

        new MyThreadWithPriority("MyThread1", Thread.MIN_PRIORITY);
        new MyThreadWithPriority("MyThread2", Thread.NORM_PRIORITY);
        new MyThreadWithPriority("MyThread3", Thread.MAX_PRIORITY);
    }
}
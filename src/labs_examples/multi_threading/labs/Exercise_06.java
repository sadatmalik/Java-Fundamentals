package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

class Counter {

    int counter;

    public synchronized int getCounter() {
        return ++counter;
    }
}

class PrintCount {

    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread t1 = new Thread(new CounterThread(counter), "t1");
        Thread t2 = new Thread(new CounterThread(counter), "t2");

        t1.start();
        t2.start();
    }
}

class CounterThread implements Runnable {

    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + counter.getCounter());
        }
    }
}
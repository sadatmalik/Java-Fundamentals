package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 */

class SendReceiveDemo {
    public static void main(String[] args) {
        Data data = new Data();

        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();

        // waiting for them both to finish before proceeding
        try {
            sender.join();
            receiver.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main finishing");

    }
}

class Sender implements Runnable {
    Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] packets = {"first packet", "second packet", "third packet", "stop"};

        for (String packet : packets) {
            data.write(packet);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Receiver implements Runnable {
    Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String packet = data.read();

        while (!"stop".equals(packet)) {
            System.out.println(packet);

            packet = data.read();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Data {

    String packet;
    boolean write = true;

    public synchronized String read() {
        while (write) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        write = true;

        notify();

        return packet;
    }

    public synchronized void write(String data) {
        while (!write) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        packet = data;

        write = false;

        notify();
    }
}
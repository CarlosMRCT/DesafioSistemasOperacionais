public class Main {
    public static void main(String[] args) {
        final int capacity = 3;

        Monitor monitor = new Monitor(capacity);

        Producer producer = new Producer(monitor);
        Consumer consumer = new Consumer(monitor);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        // Here, we don't need to join the threads as we want them to run indefinitely
        // However, we can still join to ensure a clean shutdown if needed
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }
    }
}

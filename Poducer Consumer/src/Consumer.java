public class Consumer implements Runnable {
    private final Monitor monitor;

    public Consumer(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer started consuming.");
                monitor.consume();
                Thread.sleep(1500); // Simulating consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
                break;
            }
        }
    }
}

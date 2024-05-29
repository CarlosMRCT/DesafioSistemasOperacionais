public class Producer implements Runnable {
    private final Monitor monitor;

    public Producer(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        int item = 0;
        while (true) {
            try {
                System.out.println("Producer started producing.");
                monitor.produce(item);
                item++;
                Thread.sleep(1500); // Simulating production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
                break;
            }
        }
    }
}

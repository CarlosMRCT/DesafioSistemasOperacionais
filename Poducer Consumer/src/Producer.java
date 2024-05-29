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
                Thread.sleep(1000);
                System.out.println("Produtor começou a produzir.");
                monitor.produce(item);
                item++;
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Produtor interrompido.");
                break;
            }
        }
    }
}

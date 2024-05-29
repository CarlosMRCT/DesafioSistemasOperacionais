public class Consumer implements Runnable {
    private final Monitor monitor;

    public Consumer(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1100);
                System.out.println("Consumidor começou a consumir.");
                monitor.consume();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumidor interrompido.");
                break;
            }
        }
    }
}

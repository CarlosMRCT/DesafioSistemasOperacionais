import java.util.LinkedList;
import java.util.Queue;

public class Monitor {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public Monitor(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        System.out.println("Producer Produced: " + (item + 1));
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int item = queue.poll();
        System.out.println("Consumer Consumed: " + (item + 1));
        notifyAll();
        return item;
    }
}

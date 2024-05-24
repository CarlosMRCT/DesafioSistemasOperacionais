package entities;

import java.util.LinkedList;

public class Produce {

	private Monitor monitor;

	public Produce() {

	}

	public Produce(Monitor monitor) {
		this.monitor = monitor;
	}

	public void produce(LinkedList<Integer> list, int capacity) throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {
				while (list.size() == capacity)
					wait();

				System.out.println("Producer produced-" + value);

				list.add(value++);

				notify();

				Thread.sleep(1500);

			}
		}
	}
}
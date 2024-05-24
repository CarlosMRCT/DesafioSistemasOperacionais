package entities;

import java.util.LinkedList;

public class Consume {

	private Monitor monitor;

	public Consume() {

	}

	public Consume(Monitor monitor) {
		this.monitor = monitor;
	}

	public void consume(LinkedList<Integer> list) throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (list.size() == 0)
					wait();
				int val = list.removeFirst();

				System.out.println("Consumer consumed-" + val);

				notify();

				Thread.sleep(1500);

			}
		}
	}
}

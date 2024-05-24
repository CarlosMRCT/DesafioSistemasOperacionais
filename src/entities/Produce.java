package entities;

import java.util.LinkedList;

public class Produce {

	public Produce() {

	}

	public void produce(LinkedList<Integer> list, int capacity) throws InterruptedException {
		while (true) {
			int value = 0;

			System.out.println("Producer produced-" + value);

			list.add(value++);

			Thread.sleep(1000);
		}

	}
}
package entities;

import java.util.LinkedList;

public class Consume {

	public Consume() {

	}

	public void consume(LinkedList<Integer> list) throws InterruptedException {
		while (true) {

			int val = list.removeFirst();

			System.out.println("Consumer consumed-" + val);

			Thread.sleep(1000);
		}

	}
}
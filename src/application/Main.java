package application;

import java.util.LinkedList;

import entities.Consume;
import entities.Monitor;
import entities.Produce;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		Produce pc = new Produce();
		Consume cm = new Consume();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					pc.produce(list, capacity);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cm.consume(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
		


}

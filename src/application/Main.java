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
		Monitor monitor = new Monitor();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					monitor.WaitProducer(list, capacity);
					pc.produce(list, capacity);
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					monitor.WaitConsumer(list);
					cm.consume(list);
					notify();
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

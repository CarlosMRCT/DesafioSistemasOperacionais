package entities;

import java.util.LinkedList;

public class Monitor {

	public Monitor() {

	}

	public void WaitProducer(LinkedList<Integer> list, int capacity) {
		synchronized (this) {
			while (list.size() == capacity)
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		}
	}
	
	public void WaitConsumer (LinkedList<Integer> list) {
		synchronized (this) {
			while (list.size() == 0)
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		}
	}
}

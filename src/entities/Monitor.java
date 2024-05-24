package entities;

import java.util.LinkedList;

public class Monitor {

	public Monitor() {

	}

	public void WaitProducer() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void WaitConsumer() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ponger extends ActiveComponent {

	private final Semaphore pingDone;
	private final Semaphore pongDone;

	public Ponger(final String name, final Semaphore pingDone, final Semaphore pongDone) {
		super(name);
		this.pingDone = pingDone;
		this.pongDone = pongDone;
	}

	public void run() {
		while (true) {
			try {
				this.pingDone.acquire();
				println("pong");
				this.pongDone.release();
			} catch (final InterruptedException e) {
				log("interrupted");
			}
		}
	}
}
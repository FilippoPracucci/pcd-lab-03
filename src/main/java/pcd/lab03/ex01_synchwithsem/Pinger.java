package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Pinger extends ActiveComponent {

	private final Semaphore pingDone;
	private final Semaphore pongDone;

	public Pinger(final String name, final Semaphore pingDone, final Semaphore pongDone) {
		super(name);
		this.pingDone = pingDone;
		this.pongDone = pongDone;
	}	
	
	public void run() {
		while (true) {
			try {
				this.pongDone.acquire();
				println("ping");
				this.pingDone.release();
			} catch (final InterruptedException e) {
				log("interrupted");
			}
		}
	}
}
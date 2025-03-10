package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
		Semaphore pingDone = new Semaphore(0);
		Semaphore pongDone = new Semaphore(0);

		new Pinger("Agent-Ping", pingDone, pongDone).start();
		new Ponger("Agent-Pong", pingDone, pongDone).start();

		pongDone.release();
	}

}

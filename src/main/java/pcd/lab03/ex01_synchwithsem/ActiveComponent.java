package pcd.lab03.ex01_synchwithsem;

import java.util.Random;

public abstract class ActiveComponent extends Thread {

	public ActiveComponent(final String name){
		super(name);
	}

	protected void print(String msg){
		synchronized (System.out){
			System.out.print(msg);
		}
	}

	protected void println(String msg){
		synchronized (System.out){
			System.out.println(msg);
		}
	}

	protected void log(String msg){
		synchronized (System.out){
			System.out.println("[" + this.getName()+ "] " + msg);
		}
	}

}

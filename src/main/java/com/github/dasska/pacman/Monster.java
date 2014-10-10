package com.github.dasska.pacman;

public abstract class Monster implements Runnable {
	private int sleep;
	private Thread thread;
	
	protected Point point;
	protected Game game;
	
	private volatile boolean running = false;
	
	public Monster(int sleep, Point point, Game game) {
		this.sleep = sleep;
		thread = new Thread(this);
		this.game = game;
		this.point = point;
	}
	
	public synchronized void start() {
		running = true;
		thread.start();
	}
	
	public synchronized void stop() {
		running = true;
	}
	
	public synchronized boolean isRunning() {
		return running;
	}
	

	public Point getPoint() {
		return point;
	}
	
	public abstract void move();
	
	public void run() {
		while (isRunning()) {
			move();
			if (game.kill(getPoint()))
				return;
				
			game.refresh();
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

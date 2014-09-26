package com.github.dasska.mario;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class MyJPanel extends JPanel  {
	final Mario mario;
	final Level1 level1;
	
	public MyJPanel(Mario mario, Level1 level1) {
		this.mario = mario;
		this.level1 = level1;
		registerKeyListener();
	}
	
	private void registerKeyListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()){
				case KeyEvent.VK_RIGHT:
					mario.goRight();
					repaint();
					break;
				case KeyEvent.VK_LEFT:
					mario.goLeft();
					repaint();
					break;
				case KeyEvent.VK_SPACE:
					mario.goUp();
					repaint();
					new Thread(new JumpThread()).start();
					break;
				}		
			}
		});		
	}
	
	private class JumpThread implements Runnable {
		public void run() {
			try {
				Thread.sleep(500);
				mario.goDown();
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g) {

		level1.teksturu();
		level1.removeFigure(mario.getMarioDots()); 
		level1.drawFigure(mario.getMarioDots());
		boolean[][] a = level1.getLevel1();
		super.paint(g);
		g.setColor(Color.black);
		
		
		int rectWidth = 7;
		int rectHight = 7;
		for (int i=0; i<300; ++i) {
			for (int j=0; j<25; ++j) {
				if(a[i][j]==false){
					g.drawRect(i*rectWidth, j*rectHight+50, rectWidth, rectHight);
				}
				if(a[i][j] == true){
					g.fillRect(i*rectWidth, j*rectHight+50, rectWidth, rectHight);
				}
			}
		}

	}
}

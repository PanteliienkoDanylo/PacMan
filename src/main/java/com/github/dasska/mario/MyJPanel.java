package com.github.dasska.mario;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;


public class MyJPanel extends JPanel  {

	public void formKeyPressed(KeyEvent evt){
		Mario mario = new Mario();
		switch (evt.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			mario.goRight();
			break;
		case KeyEvent.VK_LEFT:
			mario.goLeft();
			break;
		case KeyEvent.VK_SPACE:
			mario.goUp();
			break;

		}		
	}
	public void paint(Graphics g) {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("код: "+e.getKeyCode());
			}
		});

		Main main = new Main();
		Level1 level1 = new Level1();
		Mario mario = new Mario();
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

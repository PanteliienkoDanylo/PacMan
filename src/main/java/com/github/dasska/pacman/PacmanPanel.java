package com.github.dasska.pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class PacmanPanel extends JPanel  {
	private static final int GAP = 20;
	private static final int BOX = 20;
	private static final int ROUND = 8;
	
	final Game game;
	
	//private BufferedImage image;

	public PacmanPanel(Game game) {
		this.game = game;
		registerKeyListener();
		/*
		try {                
	          image = ImageIO.read(new File("wall.jpg"));
	       } catch (IOException ex) {
	    	   ex.printStackTrace();
	       }*/
	}
	
	private void registerKeyListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()){
				case KeyEvent.VK_RIGHT:
					game.getPacman().right();
					break;
				case KeyEvent.VK_LEFT:
					game.getPacman().left();
					break;
				case KeyEvent.VK_UP:
					game.getPacman().up();
					break;
				case KeyEvent.VK_DOWN:
					game.getPacman().down();
					break;
				}		
			}
		});		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		paintWalls(g);
		paintMonsters(g);
		paintPackman(g);
	}
	
	private void paintWalls(Graphics g) {
		g.setColor(Color.GRAY);
		for (int i=0; i<game.getHeight(); i++)
			for (int j=0; j<game.getHeight(); j++)
				g.drawRect(GAP+i*BOX, GAP+j*BOX, BOX, BOX);
				
		g.setColor(Color.ORANGE);
		boolean[][] walls = game.getWalls();
		for (int i=0; i<game.getHeight(); i++)
			for (int j=0; j<game.getHeight(); j++)
				if (walls[i][j])
					g.fillRect(GAP+i*BOX, GAP+j*BOX, BOX, BOX);
					//g.drawImage(image, 0, 0, null);
	}
	
	private void paintMonsters(Graphics g) {
		g.setColor(Color.RED);

    	for(Monster monster: game.getMonsters()) {
    		Point p = monster.getPoint();
    		g.fillOval(
    				GAP+p.getX()*BOX + BOX/2 - ROUND/2, 
    				GAP+p.getY()*BOX + BOX/2 - ROUND/2, 
    				ROUND, ROUND);
		}
	}
	
	private void paintPackman(Graphics g) {
		g.setColor(Color.BLUE);
		Point p = game.getPacman().getPoint();
    	g.fillOval(
    			GAP+p.getX()*BOX + BOX/2 - ROUND/2, 
    			GAP+p.getY()*BOX + BOX/2 - ROUND/2, 
    			ROUND, ROUND);		
	}
}

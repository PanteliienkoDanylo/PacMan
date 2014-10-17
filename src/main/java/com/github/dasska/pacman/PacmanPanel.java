package com.github.dasska.pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PacmanPanel extends JPanel implements GameObserver {
	private static final int GAP = 20;
	private static final int BOX = 20;
	private static final int ROUND = 8;
	
	final Game game;
	
	private BufferedImage wall;
	private BufferedImage monster;
	private BufferedImage pacman;
	private BufferedImage monsterWithBrain;
	private AudioInputStream audioInputStream;

	public PacmanPanel(Game game) {
		this.game = game;
		registerKeyListener();
		
		try {                
	          wall = ImageIO.read(getClass().getResource("/wall.jpg"));
	          monster = ImageIO.read(getClass().getResource("/monster.jpg"));
	          pacman = ImageIO.read(getClass().getResource("/pacman.jpg"));
	          monsterWithBrain = ImageIO.read(getClass().getResource("/monsterWithBrain.jpg"));
	          /*audioInputStream =AudioSystem.getAudioInputStream(
	        		  this.getClass().getResource("/pacmanMuzik.mp3"));
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioInputStream);
	          clip.start( );*/
	    } catch (IOException ex) {
	    	   ex.printStackTrace();
	    }
		
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
		paintCoins(g);
		paintMonsters(g);
		paintPackman(g);
	}
	
	private void paintWalls(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i=0; i<game.getHeight(); i++)
			for (int j=0; j<game.getHeight(); j++)
				g.fillRect(GAP+i*BOX, GAP+j*BOX, BOX, BOX);
				
				
		g.setColor(Color.ORANGE);
		boolean[][] walls = game.getWalls();
		for (int i=0; i<game.getHeight(); i++)
			for (int j=0; j<game.getHeight(); j++)
				if (walls[i][j])
					// g.fillRect(GAP+i*BOX, GAP+j*BOX, BOX, BOX);
					g.drawImage(wall, GAP+i*BOX, GAP+j*BOX, BOX, BOX, null);
	}
	
	private void paintMonsters(Graphics g) {
    	for(Monster monster: game.getMonsters()) {
    		g.setColor(monster.getColor());
    		Point p = monster.getPoint();
    		/*g.fillOval(
    				GAP+p.getX()*BOX + BOX/2 - ROUND/2, 
    				GAP+p.getY()*BOX + BOX/2 - ROUND/2, 
    				ROUND, ROUND);*/
    		if (monster instanceof MonsterDecart)
    			g.drawImage(this.monsterWithBrain, GAP+p.getX()*BOX, GAP+p.getY()*BOX, BOX, BOX, null);
    		else
    			g.drawImage(this.monster, GAP+p.getX()*BOX, GAP+p.getY()*BOX, BOX, BOX, null);
    		
		}
	}
	
	private void paintMonstersDecart(Graphics g) {
    	for(Monster monster: game.getMonsters()) {
    		g.setColor(monster.getColor());
    		Point p = monster.getPoint();
    		/*g.fillOval(
    				GAP+p.getX()*BOX + BOX/2 - ROUND/2, 
    				GAP+p.getY()*BOX + BOX/2 - ROUND/2, 
    				ROUND, ROUND);*/
    		g.drawImage(this.monster, GAP+p.getX()*BOX, GAP+p.getY()*BOX, BOX, BOX, null);
    		
		}
	}
		
	private void paintCoins(Graphics g) {
		g.setColor(Color.GREEN);
		
    	for(Point p: game.getCoins()) {
    		g.fillOval(
    				GAP+p.getX()*BOX + BOX/2 - ROUND/2, 
    				GAP+p.getY()*BOX + BOX/2 - ROUND/2, 
    				ROUND, ROUND);
		}
	}
	
	private void paintPackman(Graphics g) {
		g.setColor(Color.BLUE);
		Point p = game.getPacman().getPoint();
    	/*g.fillOval(
    			GAP+p.getX()*BOX + BOX/2 - ROUND/2, 
    			GAP+p.getY()*BOX + BOX/2 - ROUND/2, 
    			ROUND, ROUND);	*/	
		g.drawImage(pacman, GAP+p.getX()*BOX, GAP+p.getY()*BOX, BOX, BOX, null);
	}
	
	public void refresh() {
		repaint();
	}
	
	public void win() {
		repaint();
	}
	
	public void gameOver() {
    	repaint();
	}
}

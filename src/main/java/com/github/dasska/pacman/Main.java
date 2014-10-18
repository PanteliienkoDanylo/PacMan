package com.github.dasska.pacman;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;


public class Main extends JFrame implements GameObserver {
	private static final int MAX_LEVEL = 4;
	
	private PacmanPanel contentPane;
	private int level;
	private Game game;
	private Monster monster;
	private JTextField textField;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		final Main frame = new Main();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.startLevel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);

		textField2 = new JTextField();
		textField2.setBounds(506, 27, 152, 33);
		textField2.setColumns(10);

		textField = new JTextField();
		textField.setBounds(506, 67, 152, 33);
		textField.setColumns(10);		

		level = 1;
	}
	
	public void startLevel() {
		setVisible(false);
		
		game = createGame(level);
		game.addObserver(this);
		
		contentPane = new PacmanPanel(game);
		contentPane.setFocusable(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		contentPane.add(textField2);
		contentPane.add(textField);
		
		setContentPane(contentPane);
		
		game.addObserver(contentPane);
		
		textField.setText("Level " + level);

		game.start();
		setVisible(true);
		this.repaint();
		
	}
	
	private Game createGame(int level) {
		Game newGame = null;
		switch (level) {
			case 1: newGame = new Level1();
					break;
			case 2: newGame = new Level2();
					break;
			case 3: newGame = new Level3();
					break;
		}
		return newGame;
	}
	
	public void refresh() {
		textField2.setText(((Integer)game.getCoins().size()).toString());
	}
	
	public void win() {
		textField.setText("Win !");
		game.stop();
		
		if (level < MAX_LEVEL) {
			level++;
			EventQueue.invokeLater(new Runnable(){
				public void run() {
					try {
						startLevel();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	public void gameOver() {
		textField.setText("Game Over !");
    	game.stop();
	}	
}

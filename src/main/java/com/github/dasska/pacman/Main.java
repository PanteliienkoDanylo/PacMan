package com.github.dasska.pacman;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;


public class Main extends JFrame implements GameObserver {
	private PacmanPanel contentPane;
	private Game game;
	private Monster monster;
	private JTextField textField;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
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
		game = new Level2();
		game.addObserver(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new PacmanPanel(game);
		contentPane.setFocusable(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		game.addObserver(contentPane);
		
		textField2 = new JTextField();
		textField2.setBounds(506, 27, 152, 33);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(506, 67, 152, 33);
		contentPane.add(textField);
		textField.setColumns(10);		
		game.start();
		
	}
	
	public void refresh() {
		textField2.setText(((Integer)game.getCoins().size()).toString());
	}
	
	public void win() {
		textField.setText("Win !");
		game.stop();
	}
	
	public void gameOver() {
		textField.setText("Game Over !");
    	game.stop();
	}	
}

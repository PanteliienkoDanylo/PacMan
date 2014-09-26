package com.github.dasska.mario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		Mario mario = new Mario();
		Level1 level1 = new Level1();
		level1.drawFigure(mario.getMarioDots());
		//level1.drawFigure(level1.getLevel1Dots());
		boolean[][] a = level1.getLevel1();
		for (int i=0; i<1; i++){
			for (int j=0; j<1; j++){
				if(a[i][j]==false){
					System.out.print("_");
				}}
				System.out.println();
				/*if (a[i][j]==true){
					System.out.print("X");
				}*/	
		}
		//System.out.println("_");
		
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new MyJPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoright = new JButton("goRight");
		btnGoright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mario mario = new Mario();
				mario.goRight();
				System.out.println(mario.startX);
			}
		});
		btnGoright.setBounds(226, 228, 89, 23);
		contentPane.add(btnGoright);
	}
}

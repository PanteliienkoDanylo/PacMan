package com.github.dasska.mario;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;


public class Level1 {

	private static boolean[][] level1 = null;
	private static int width = 300;
	private static int height = 25;

	public static boolean[][] getLevel1(){
		if (level1 == null){
			level1 = new boolean[300][25];
		}
		return level1;
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void teksturu(){
		getLevel1();
		for (int i=0; i<300; ++i) {
			for (int j=0; j<25; ++j) {
				level1[i][24] = true;
			}
		}
	}

	public void drawFigure(ArrayList<Point> figureDots){
		getLevel1();
		Iterator<Point> i = figureDots.iterator();
		while( i.hasNext()){
			Point p = i.next();
			level1[p.x][p.y] = true;	
		}	

	}

	public void removeFigure(ArrayList<Point> figureDots){
		Iterator<Point> i = figureDots.iterator();
		while( i.hasNext()){
			Point p = i.next();
			level1[p.x][p.y] = false;	
		}
	}




}

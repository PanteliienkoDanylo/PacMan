package com.github.dasska.mario;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;


public class Mario{
    private Level1 level1;
    private Mario mario;
	private  ArrayList <Point> marioDots = new ArrayList<Point>();
	int startX = 2;
	int startY = 23;
	public Mario(Level1 level1) {
		this.level1 = level1;
		
		marioDots.add(new Point(startX, startY));
		marioDots.add(new Point(startX, startY-1));
		marioDots.add(new Point(startX, startY-2));
		marioDots.add(new Point(startX, startY-3));
	}
	
	public  ArrayList<Point> getMarioDots() {
		return marioDots;
	}
	
	public void gravity(){
		Level1 level1 = new Level1();
		level1.removeFigure(getMarioDots());
		for (int i=0; i<299; ++i) {
			for (int j=0; j<23; ++j) {
				if (level1.getLevel1()[i][j+1] == true && level1.getLevel1()[i][j] == false){
					goDown();
				}
			}
		}
	}
	public void tecstruct(){
		Level1 level1 = new Level1();
		level1.removeFigure(getMarioDots());
		for (int i=0; i<299; ++i) {
			for (int j=0; j<23; ++j) {
				if (level1.getLevel1()[i][j+1] == true && level1.getLevel1()[i][j] == true){
					//dont goDown();
				}
				if (level1.getLevel1()[i][j-1] == true && level1.getLevel1()[i][j] == true){
					//dont goUp();
				}
				if (level1.getLevel1()[i-1][j] == true && level1.getLevel1()[i][j] == true){
					//dont goLeft();
				}
				if (level1.getLevel1()[i+1][j] == true && level1.getLevel1()[i][j] == true){
					//dont goRight();
				}
			}
		}
	}
	public void goLeft(){
		Level1 level1 = new Level1();
		level1.removeFigure(getMarioDots());
		startX = startX-1;
		marioDots.get(0).x=startX;
		marioDots.get(1).x=startX;
		marioDots.get(2).x=startX;
		marioDots.get(3).x=startX;
		level1.drawFigure(getMarioDots());
	}
	
	public void goRight(){
		level1.removeFigure(getMarioDots());
		startX = startX+1;
		marioDots.get(0).x=startX;
		marioDots.get(1).x=startX;
		marioDots.get(2).x=startX;
		marioDots.get(3).x=startX;
		level1.drawFigure(getMarioDots());
		
	}
	public void goUp(){
		level1.removeFigure(getMarioDots());
		startY = startY-1;
		marioDots.get(0).y=startY;
		marioDots.get(1).y=startY-1;
		marioDots.get(2).y=startY-2;
		marioDots.get(3).y=startY-3;
		level1.drawFigure(getMarioDots());
		
	}
	public void goDown(){
		level1.removeFigure(getMarioDots());
		startY = startY+1;
		marioDots.get(0).y=startY;
		marioDots.get(1).y=startY-1;
		marioDots.get(2).y=startY-2;
		marioDots.get(3).y=startY-3;
		level1.drawFigure(getMarioDots());
	}
}

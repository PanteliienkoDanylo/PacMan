package com.github.dasska.pacman;

public class MonsterDecart extends Monster {

	public MonsterDecart(int sleep, Point point, Game game) {
		super(sleep, point, game);
	}

	@Override
	public void move() {
		Point pLeft = new Point(point);
		pLeft.left(game.getWidth());
		
		Point pRight = new Point(point);
		pRight.right(game.getWidth());
		
		Point pUp = new Point(point);
		pUp.up(game.getHeight());
		
		Point pDown = new Point(point);
		pDown.down(game.getHeight());
		
		point = getMin(pLeft, pRight, pUp, pDown);
	}
	
	private static double sqr(double x){
		return x*x;
	}
	
	public static double length(Point p1, Point p2) {
		return Math.sqrt(sqr(p1.getX() - p2.getX())+sqr(p1.getY() - p2.getY()));
	}
	
	private Point getMin(Point pLeft ,Point pRight, Point pUp, Point pDown) {
		Point min = point;
		double minLength = Double.POSITIVE_INFINITY;
		
		if (game.canMoveLeft(point)) {
			double length = length(pLeft, game.getPacman().getPoint());
			if (length < minLength) {
				minLength = length;
				min = pLeft;
			}
		}
		
		if (game.canMoveRight(point)) {
			double length = length(pRight, game.getPacman().getPoint());
			if (length < minLength) {
				minLength = length;
				min = pRight;
			}
		}
		
		if (game.canMoveUp(point)) {
			double length = length(pUp, game.getPacman().getPoint());
			if (length < minLength) {
				minLength = length;
				min = pUp;
			}
		}
		
		if (game.canMoveDown(point)) {
			double length = length(pDown, game.getPacman().getPoint());
			if (length < minLength) {
				minLength = length;
				min = pDown;
			}
		}
		
		return min;
	}

}

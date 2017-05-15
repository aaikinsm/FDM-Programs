package com.fdmgroup;

public class PointOperation {

	public double calculateDistance(Point p1, Point p2) {
		if (p1 == null || p2 == null || p1.getX() < 0 || p2.getX() < 0 || p1.getY() < 0 || p2.getY() < 0)
			return 0;
		double d = Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
		return d;
	}

	public double div(int i, int j) {
		return i/j;
	}

}

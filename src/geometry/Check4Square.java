package geometry;

import java.util.HashSet;

/**
 * Checks if 4 points makes a square
 * @author jenah
 *
 */
public class Check4Square {

	public static void main(String[] args) {
		Point p1= new Point(20, 10);
		Point p2= new Point(10, 20);
		Point p3= new Point(20, 20);
		Point p4= new Point(10, 10);
		
		boolean isSquare = checkIfSquare(p1,p2,p3,p4);
		System.out.println("Is square possible:: "+isSquare);
		
		p1= new Point(10, 10);
		p2= new Point(30, 20);
		p3= new Point(10, 20);
		p4= new Point(30, 10);
		
		isSquare = checkIfSquare(p1,p2,p3,p4);
		System.out.println("Is square possible:: "+isSquare);
		
		p1= new Point(10, 10);
		p2= new Point(10, 10);
		p3= new Point(10, 10);
		p4= new Point(10, 10);
		
		isSquare = checkIfSquare(p1,p2,p3,p4);
		System.out.println("Is square possible:: "+isSquare);

	}
	
	private static boolean checkIfSquare(Point p1, Point p2, Point p3, Point p4) {
		if(isOneOfPointSame(p1,p2,p3,p4)) {
			return false;
		}
		int cx= (p1.x+p2.x+p3.x+p4.x)/4;
		int cy= (p1.y+p2.y+p3.y+p4.y)/4;
		Point cp= new Point(cx, cy);
		if(isEquiDistFromCentre(cp,p1,p2,p3,p4) && isEquiDistFromEach(p1,p2,p3,p4)) {
			return true;
		}
		return false;
		
	}

	private static boolean isOneOfPointSame(Point p1, Point p2, Point p3, Point p4) {
		HashSet<Point> points= new HashSet<>();
		if(points.add(p1) && points.add(p2) && points.add(p3) && points.add(p4)) 
			return false;
		return true;
	}

	private static boolean isEquiDistFromEach(Point p1, Point p2, Point p3, Point p4) {
		double d12= dist(p1, p2);
		double d13= dist(p1, p3);
		double d14= dist(p1, p4);
		
		if(d12== d13 && d12*Math.sqrt(2)== d14) {
			return true;
		}
		
		if(d12== d14 && d12*Math.sqrt(2)== d13) {
			return true;
		}
		if(d14== d13 && d13*Math.sqrt(2)== d12) {
			return true;
		}
		return false;
	}

	private static boolean isEquiDistFromCentre(Point cp, Point p1, Point p2, Point p3, Point p4) {
		if(dist(cp,p1)== dist(cp,p2) && dist(cp, p2)== dist(cp, p3) && dist(cp, p3)== dist(cp, p4)) {
			return true;
		}
		return false;
	}

	private static double dist(Point cp, Point p2) {
		return Math.sqrt(Math.pow(p2.x-cp.x, 2)+Math.pow(p2.y-cp.y, 2));
	}

	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x= x;
			this.y= y;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj instanceof Point && ((Point)obj).x== this.x && ((Point)obj).y== this.y;
		}
		
		@Override
		public int hashCode() {
			return (31*x+y)*31;
		}
	}

}

package geometry;

/**
 * Main Idea: Area of large trianle= sum of 3 triangles made with the given point
 * 
 * @author hitansu (hitansu166@gmail.com)
 *
 */
public class CheckPointInsideTriangle {

	public static void main(String[] args) {
		
		Point tp1= new Point(0,0);
		Point tp2= new Point(20,0);
		Point tp3= new Point(10,30);
		
		Point p= new Point(30,30);
		
		boolean isInside= checkIfPointInsideTrianle(tp1,tp2,tp3,p);
		System.out.println("Is triangle possible:: "+isInside);
		
		p= new Point(10,15);
		isInside= checkIfPointInsideTrianle(tp1,tp2,tp3,p);
		System.out.println("Is triangle possible:: "+isInside);
	}
	
	private static boolean checkIfPointInsideTrianle(Point tp1, Point tp2, Point tp3, Point p) {
		double areaTriangle= calculateArea(tp1,tp2,tp3);
		double area1= calculateArea(tp1, tp2, p);
		double area2= calculateArea(tp2, tp3, p);
		double area3= calculateArea(tp3, tp1, p);
		
		if(areaTriangle== (area1+area2+area3)) {
			return true;
		}
		return false;
	}

	private static double calculateArea(Point tp1, Point tp2, Point tp3) {
		return Math.abs((tp1.x*(tp2.y-tp3.y)+tp2.x*(tp3.y-tp1.y)+tp3.x*(tp1.y-tp2.y)));
	}

	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x= x;
			this.y= y;
		}
	}
}

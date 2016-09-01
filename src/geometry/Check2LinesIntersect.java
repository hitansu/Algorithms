package geometry;

public class Check2LinesIntersect {

	public static void main(String[] args) {
		Point p1= new Point(1,1);
		Point q1= new Point(10,1);
		Point p2= new Point(1,2);
		Point q2= new Point(10,2);
		
		boolean isIntersect = if2LinesIntersect(p1, q1, p2, q2);
		System.out.println("Is 2 lines intersect:: "+isIntersect);
		
	    p1 = new Point(10, 0);
	    q1 = new Point(0, 10);
	    p2 = new Point(0, 0);
	    q2 = new Point(10, 10);
	    
	    isIntersect = if2LinesIntersect(p1, q1, p2, q2);
		System.out.println("Is 2 lines intersect:: "+isIntersect);
		
		p1 = new Point(-5, -5);
		q1 = new Point(0, 0);
		p2 = new Point(1, 1);
		q2 = new Point(10, 10);
		
		isIntersect = if2LinesIntersect(p1, q1, p2, q2);
		System.out.println("Is 2 lines intersect:: "+isIntersect);
	}
	
	private static boolean if2LinesIntersect(Point p1, Point q1, Point p2, Point q2) {
		int r1= getRotation(p1,q1,p2);
		int r2= getRotation(p1, q1, q2);
		int r3= getRotation(p2, q2, p1);
		int r4= getRotation(p2, q2, q1);
		
		if(r1!= r2 && r3!= r4) {
			return true;
		}
		
		if(r1== 0 && isOnlineSegment(p1,q1,p2)){
			return true;
		}
		if(r2== 0 && isOnlineSegment(p1, q1, q2)) {
			return true;
		}
		if(r3== 0 && isOnlineSegment(p2, q2, p1)) {
			return true;
		}
		if(r4== 0 && isOnlineSegment(p2, q2, q1)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean isOnlineSegment(Point p1, Point q1, Point p2) {
		return p2.x<= Math.max(p1.x,q1.x) && 
				p2.x>= Math.min(p1.x, q1.x) &&
				p2.y<= Math.max(p1.y, q1.y) &&
				p2.y>= Math.min(p1.y, q1.y);
	}

	private static int getRotation(Point p1, Point q1, Point p2) {
		return ((q1.y-p1.y)*(p2.x-q1.x))-((p2.y-q1.y)*(q1.x-p1.x));
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

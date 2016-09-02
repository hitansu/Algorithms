package geometry;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairPoint {

	public static void main(String[] args) {
		Point p[] = {new Point(2,3), new Point(12,30), new Point(40,50), new Point(5,1), new Point(12,10), new Point(3,4)};
		Result r= findClosestPair(p);
		System.out.println("Close dist:: "+r.d+"Close points:: ("+r.p1.x+","+r.p1.y+")"+"("+r.p2.x+","+r.p2.y+")");
	}
	
	private static Result findClosestPair(Point[] p) {
		Point[] px= Arrays.copyOf(p, p.length);
		Arrays.sort(px, compareX);
		Point[] py= Arrays.copyOf(p, p.length);
		Arrays.sort(py, compareY);
		return findClosestPairUtil(px, py, 0, p.length-1);
		
	}
	
	private static Result findClosestPairUtil(Point[] px, Point[] py, int l, int h) {
		int size= h-l+1;
		if(size<= 3) {
			return calClosest(px,l,h);
		}
		int mid= l+h/2;
		Point midP= px[mid];
		Point[] pyl= new Point[mid-l+1];
		Point[] pyr= new Point[h-mid];
		int j= 0,k= 0;
		for(int i= l;i<=h;i++) {
			if(py[i].x<=midP.x) {
				pyl[j]= py[i];
				j++;
			} else {
				pyr[k]= py[i];
				k++;
			}
		}
		Result dlP = findClosestPairUtil(px, pyl, l, mid);
		Result drP = findClosestPairUtil(px, pyr, mid+1, h);
		Result r= dlP.d<drP.d ? dlP:drP;
		double d= Math.min(dlP.d, drP.d);
		Point[] strip= new Point[size];
		j= 0;
		for(int i= l;i<=h;i++) {
			if(dist(midP,py[i])<d) {
				strip[j]= py[i];
				j++;
			}
		}
		
		return findClosestStrip(strip, d, j, r);
	}

	private static Result findClosestStrip(Point[] strip, double dmin, int j, Result r) {
		double min= dmin;
		for(int i= 0;i<j;i++) {
			for(int k= i+1;k<j && Math.abs(strip[i].y-strip[j].y)<min;k++) {
				double d= dist(strip[i], strip[j]);
				if(Math.abs(d)<min) {
					r.p1= strip[i];
					r.p2= strip[j];
					r.d= d;
					min= d;
				}
			}
		}
		return r;
	}

	private static Result calClosest(Point[] px, int l, int h) {
		double min= Integer.MAX_VALUE;
		Result r= new Result();
		for(int i= l;i<=h;i++) {
			for(int j= i+1;j<=h;j++) {
				double d= dist(px[i], px[j]);
				if(d<min) {
					r.p1= px[i];
					r.p2= px[j];
					r.d= d;
					min= d;
				}
			}
		}
		return r;
	}
	
	private static double dist(Point p1, Point p2) {
		return Math.sqrt(Math.abs((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)));	
	}

	private static Comparator<Point> compareX= new Comparator<ClosestPairPoint.Point>() {
		
		@Override
		public int compare(Point p1, Point p2) {
			if(p1.x<p2.x) {
				return -1;
			} else {
				return 1;
			}
		}
	};
	
	private static Comparator<Point> compareY= new Comparator<ClosestPairPoint.Point>() {
		
		@Override
		public int compare(Point p1, Point p2) {
			if(p1.y<p2.y) {
				return -1;
			} else {
				return 1;
			}
		}
	};
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x= x;
			this.y= y;
		}
	}
	
	static class Result {
		Point p1;
		Point p2;
		double d;
	}

}

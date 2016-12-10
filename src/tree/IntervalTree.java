package tree;

public class IntervalTree {

	public static void main(String[] args) {
		
		int[][] intervals= {	{15, 20}, 
				       			{10, 30}, 
				       			{17,19}, 
				       			{5, 20}, 
				       			{12, 15}, 
				       			{30, 40}
				       		};
		int[] search= {6, 7};
		
		INode root= buildIntervalTree(intervals);
		traverse(root);
		Interval i= searchInterval(root, new Interval(search[0], search[1]));
		System.out.println("Found interval: ["+i.low+", "+i.high+"]");
	}
	
	private static Interval searchInterval(INode root, Interval i) {
		if(root== null) return null;
		if(root.i.low< i.high && i.low< root.i.high) {
			return root.i;
		}
		if(i.low<root.max) {
			return searchInterval(root.left, i);
		} else {
			return searchInterval(root.right, i);
		}
	}

	private static void traverse(INode root) {
		if(root== null) return;
		traverse(root.left);
		System.out.println("["+root.i.low+", "+root.i.high+"]  MAX: "+root.max);
		traverse(root.right);
		
	}

	private static INode buildIntervalTree(int[][] intervals) {
		INode root= null;
		for(int[] i: intervals) {
			root= insert(root, new Interval(i[0], i[1]));
		}
		return root;
	}
	
	private static INode insert(INode root, Interval i) {
		if(root== null) {
			root= new INode(i);
			root.max= i.high;
			return root;
		}
		int max= Integer.MIN_VALUE;
		if(i.low<root.i.low) {
			root.left= insert(root.left, i);
			max= root.left.max;
		} else {
			root.right= insert(root.right, i);
			max= root.right.max;
		}
		
		if(root.max<max) {
			root.max= max;
		}	
		return root;
		
	}

	static class Interval {
		int low;
		int high;
		
		public Interval(int low, int high) {
			this.low= low;
			this.high= high;
		}
	}
	
	static class INode {
		Interval i;
		INode left;
		INode right;
		int max;
		
		public INode(Interval i) {
			this.i= i;
		}
	}
	

}
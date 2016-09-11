package tree;

public class MaxSumBetween2Leaves {

	public static void main(String[] args) {
		
		Result r= new Result();
		Node root= new Node(-15);
		root.left= new Node(5);
		root.right= new Node(6);
		root.right.left= new Node(3);
		root.right.right= new Node(9);
		root.right.right.right= new Node(0);
		root.right.right.right.left= new Node(4);
		root.right.right.right.right= new Node(-1);
		root.right.right.right.right.left= new Node(10);
		root.left.left= new Node(-8);
		root.left.right= new Node(1);
		root.left.left.left= new Node(2);
		root.left.left.right= new Node(6);
		
		findMaxSumBetween2Leaves(root, r);
		System.out.println("Max sum between 2 leaves:: "+r.maxsum);
	}

	private static int findMaxSumBetween2Leaves(Node root, Result r) {
		if(root== null) return 0;
		if(root.left== null && root.right== null) return root.data;
		
		int lsum= findMaxSumBetween2Leaves(root.left, r);
		int rsum= findMaxSumBetween2Leaves(root.right, r);
		
		if(root.left!= null && root.right!= null) {
			r.maxsum= Math.max(lsum+root.data+rsum, r.maxsum);
			return Math.max(lsum, rsum)+root.data;
		}
		return root.left== null?rsum+root.data:lsum+root.data;
	}

	static class Result {
		int maxsum= Integer.MIN_VALUE;
	}
}

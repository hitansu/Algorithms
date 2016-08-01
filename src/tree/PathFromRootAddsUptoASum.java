package tree;

public class PathFromRootAddsUptoASum {

	public static void main(String[] args) {
		Node root= new Node(10);
		root.left= new Node(8);
		root.right= new Node(2);
		root.left.left= new Node(3);
		root.left.right= new Node(5);
		root.right.left= new Node(2);
		root.right.right= new Node(20);
		
		boolean isPossible= isSumPossible(root, 32);
		System.out.println("Is sum possible:: "+isPossible);
		System.out.println("Is sum 18 possible:: "+isSumPossible(root, 18));
		System.out.println("Is sum 23 possible:: "+isSumPossible(root, 23));
		System.out.println("Is sum 21 possible:: "+isSumPossible(root, 21));
		System.out.println("Is sum 14 possible:: "+isSumPossible(root, 14));
		System.out.println("Is sum 12 possible:: "+isSumPossible(root, 12));
		System.out.println("Is sum 2 possible:: "+isSumPossible(root, 2));
		System.out.println("Is sum 4 possible:: "+isSumPossible(root, 4));
		System.out.println("Is sum 25 possible:: "+isSumPossible(root, 25));
	}

	private static boolean isSumPossible(Node root, int sum) {
		if(sum== 0) return true;
		if(sum<0) return false;
		if(root== null && sum>0) return false;
		if(isSumPossible(root.left, sum-root.data)) {
			return true;
		}
		return isSumPossible(root.right, sum-root.data);
	}
	
}

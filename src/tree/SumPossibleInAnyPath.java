package tree;

public class SumPossibleInAnyPath {

	public static void main(String[] args) {
		Node root= new Node(10);
		root.left= new Node(8);
		root.right= new Node(2);
		root.left.left= new Node(3);
		root.left.right= new Node(5);
		root.left.left.left= new Node(6);
		root.left.right.left= new Node(7);
		root.right.left= new Node(2);
		root.right.right= new Node(20);
		root.right.left.right= new Node(9);
		root.right.right.right= new Node(10);
		
		System.out.println("Is sum 25 possible:: "+isSumPossibleInAnyPath(root, 25));
		System.out.println("Is sum 22 possible:: "+isSumPossibleInAnyPath(root, 22));
		System.out.println("Is sum 13 possible:: "+isSumPossibleInAnyPath(root, 13));
		System.out.println("Is sum 50 possible:: "+isSumPossibleInAnyPath(root, 50));
		System.out.println("Is sum 20 possible:: "+isSumPossibleInAnyPath(root, 20));
	}
	
	private static boolean isSumPossibleInAnyPath(Node root, int sum) {
		return isSumInAnypathPossibleUtil2(root, sum, sum);
	}

	private static boolean isSumInAnypathPossibleUtil(Node root, int currSum, int sumToMatch) {
		if(currSum== 0) return true;
		if(currSum<0 || (root== null && currSum>0)) return false;
		if(	isSumInAnypathPossibleUtil(root.left, currSum-root.data, sumToMatch) ||
			isSumInAnypathPossibleUtil(root.right, currSum-root.data, sumToMatch)) {
			return true;
		}
		
		currSum= sumToMatch;
		if(isSumInAnypathPossibleUtil(root.left, currSum-root.data, sumToMatch) ||
				isSumInAnypathPossibleUtil(root.right, currSum-root.data, sumToMatch)) {
			return true;
		}
		return false;
	}
	
	private static boolean isSumInAnypathPossibleUtil2(Node root, int currSum, int sumToMatch) {
		if(currSum== 0) return true;
		if(currSum<0 || (root== null && currSum!= 0)) return false;
		if(	isSumInAnypathPossibleUtil2(root.left, currSum-root.data, sumToMatch) ||
			isSumInAnypathPossibleUtil2(root.right, currSum-root.data, sumToMatch) ||
			isSumInAnypathPossibleUtil2(root.left, sumToMatch, sumToMatch) ||
			isSumInAnypathPossibleUtil2(root.right, sumToMatch, sumToMatch)) {
			return true;
		}
		return false;
	}

}

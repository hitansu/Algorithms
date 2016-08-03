package tree;

public class SearchNode {

	public static void main(String[] args) {
		Node root= new Node(4);
		root.left= new Node(2);
		root.right= new Node(5);
		root.left.left= new Node(1);
		root.left.right= new Node(3);
		root.right= new Node(5);
		
		boolean isfound= search(root, 6);
		System.out.println("Is 6 found:: "+isfound);
		
		System.out.println("Is 5 found:: "+search(root, 5));
	}

	private static boolean search(Node root, int element) {
		if(root== null) return false;
		if(root.data== element) return true;
		boolean isFound= search(root.left, element);
		if(!isFound) {
			isFound= search(root.right, element);
		}
		return isFound;
	}

}

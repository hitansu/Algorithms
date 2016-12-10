package tree;

public class BoundaryView {

	public static void main(String[] args) {
		Node root= new Node(20);
		root.left= new Node(8);
		root.right= new Node(22);
		root.right.right= new Node(25);
		root.left.left= new Node(4);
		root.left.right= new Node(12);
		root.left.right.left= new Node(10);
		root.left.right.right= new Node(14);
		
		printBoundary(root);

	}
	
	static void printBoundary(Node root) {
		printLeft(root);
		printLeaf(root);
		printRight(root.right);
	}

	private static void printRight(Node right) {
		if(right== null || (right.left== null && right.right== null)) return;
		printRight(right.right);
		System.out.print(right.data+" ");
		
	}

	private static void printLeaf(Node root) {
		if(root== null) return;
		if(root.left== null && root.right== null) {
			System.out.print(root.data+" ");
		}
		printLeaf(root.left);
		printLeaf(root.right);
	}

	private static void printLeft(Node root) {
		if(root== null || (root.left== null && root.right== null)) return;
		System.out.print(root.data+" ");
		printLeft(root.left);	
	}

}

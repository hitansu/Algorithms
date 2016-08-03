package tree;

public class SizeOfTree {

	public static void main(String[] args) {
		Node root= new Node(20);
		root.left= new Node(-2);
		root.right= new Node(7);
		root.right.left= new Node(9);
		root.right.left.right= new Node(-12);
		root.right.left.left= new Node(5);
		root.right.left.left.left= new Node(15);
		root.right.left.left.right= new Node(3);
		root.right.left.left.left.left= new Node(6);
		root.right.right= new Node(8);
		root.left.left= new Node(8);
		root.left.right= new Node(-4);
		
		System.out.println("Size of tree:: "+sizeOfTree(root));
	}

	private static int sizeOfTree(Node root) {
		if(root== null) return 0;
		int lsize= sizeOfTree(root.left);
		int rsize= sizeOfTree(root.right);
		
		return lsize+1+rsize;
	}

}

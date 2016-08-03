package tree;

public class HeightOfTree {

	public static void main(String[] args) {

		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.right.left= new Node(4);
		root.right.right= new Node(5);
		
		root.left.right= new Node(6);
		root.left.right.right= new Node(7);
		root.left.right.right.left= new Node(12);
		root.left.right.right.right= new Node(8);
		root.left.right.right.right.right= new Node(10);
		
		System.out.println("Height of Tree:: "+getHeight(root));
	}

	private static int getHeight(Node root) {
		if(root== null) return 0;
		int lh= getHeight(root.left);
		int rh= getHeight(root.right);
		 return Math.max(lh, rh)+1;
	}
}

package tree;

public class ConvertTreeTtoSumTree {

	public static void main(String[] args) {
		
		Node root= new Node(10);
		root.left= new Node(-2);
		root.right= new Node(6);
		root.left.left= new Node(8);
		root.left.right= new Node(-4);
		root.right.left= new Node(7);
		root.right.right= new Node(5);
		
		toSumTree(root);
		printTree(root);

	}
	
	private static void printTree(Node root) {
		if(root== null) return;
		printTree(root.left);
		System.out.print(root.data+" ");
		printTree(root.right);
		
	}

	private static int toSumTree(Node root) {
		if(root== null) return 0;
		int left= toSumTree(root.left);
		int right= toSumTree(root.right);
		int tmp= root.data;
		root.data= left+right;
		return root.data+tmp;
	}

}

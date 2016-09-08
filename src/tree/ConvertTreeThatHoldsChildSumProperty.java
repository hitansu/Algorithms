package tree;

public class ConvertTreeThatHoldsChildSumProperty {

	public static void main(String[] args) {

		Node root= new Node(50);
		root.left= new Node(7);
		root.right= new Node(2);
		root.left.left= new Node(3);
		root.left.right= new Node(5);
		root.right.left= new Node(1);
		root.right.right= new Node(30);
		
		traverse(root);
		Node newRoot= getChildSumTree(root);
		System.out.println("\nAfter.....");
		traverse(newRoot);
	}

	private static void traverse(Node root) {
		if(root!= null) {
			traverse(root.left);
			System.out.print(root.data+" ");
			traverse(root.right);
		}
		
	}

	private static Node getChildSumTree(Node root) {
		if(root== null) {
			return new Node(0);
		}
		Node left= getChildSumTree(root.left);
		Node right= getChildSumTree(root.right);
		if(root.data<(left.data+right.data)) {
			root.data= left.data+right.data;
		} else if(root.data>(left.data+right.data) && root.left!= null && root.right!= null) { // for leaf we dont need to process
			int diff= root.data-(left.data+right.data);
			root.left.data= root.left.data+diff;
			root.left= getChildSumTree(root.left);
		}
		return root;
	}

}

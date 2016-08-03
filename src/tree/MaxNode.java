package tree;

public class MaxNode {

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
		
		Node node= findMaxNode(root);
		System.out.println("Max node:: "+node.data);
	}

	private static Node findMaxNode(Node root) {
		if(root== null) return new Node(Integer.MIN_VALUE);
		Node max= root;
		Node lMax= findMaxNode(root.left);
		Node rMax= findMaxNode(root.right);
		if(max.data<lMax.data) {
			max= lMax;
		}
		if(max.data<rMax.data) {
			max= rMax;
		}
	   return max;
	}

}

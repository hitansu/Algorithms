package tree;

public class RightView {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		root.right.right.right= new Node(8);
		
		printRightView(root, 1);
	}

	static int max_level= 0;
	private static void printRightView(Node root, int level) {
		if(root== null) return;
		if(level>max_level) {
			max_level= level;
			System.out.print(root.data+" ");
		}
		printRightView(root.right, level+1);
		printRightView(root.left, level+1);
	}
}

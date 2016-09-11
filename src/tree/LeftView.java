package tree;

public class LeftView {

	public static void main(String[] args) {
		Node root= new Node(12);
		root.left= new Node(10);
		root.right= new Node(30);
		root.right.left= new Node(25);
		root.right.right= new Node(40);
		
		printLeftView(root, 1);

	}

	static int max_level= 0;
	private static void printLeftView(Node root, int level) {
		if(root== null) return;
		if(level>max_level) {
			max_level= level;
			System.out.print(root.data+" ");
		}
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);	
	}

}

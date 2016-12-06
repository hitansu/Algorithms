package tree;

import java.util.Stack;

public class PreOrderIterative {

	public static void main(String[] args) {
		Node root= new Node(20);
		root.left= new Node(10);
		root.right= new Node(30);
		root.left.left= new Node(24);
		root.left.right= new Node(25);
		root.left.left.left= new Node(28);
		root.left.left.right= new Node(27);
		root.left.right.left= new Node(32);
		root.left.right.right= new Node(34);
		root.right.left= new Node(42);
		root.right.right= new Node(45);
		root.right.right.left= new Node(50);
		root.right.right.right= new Node(60);
		
		preOrderIterative(root);

	}
	
	private static void preOrderIterative(Node root) {
		Stack<Node> s= new Stack<>();
		while(true) {
			if(root!= null) {
				System.out.print(root.data+" ");
				if(root.right!= null)
					s.push(root.right);
				root= root.left;
			} else {
				if(s.isEmpty()) {
					return;
				}
				root= s.pop();
			}
		}
	}
}

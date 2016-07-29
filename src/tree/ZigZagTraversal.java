package tree;

import java.util.Stack;

public class ZigZagTraversal {

	/**
	 *         1
	 *       2    3
	 *     4  5  6  7
	 *   8  9     
	 *     
	 * @param args
	 */
	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.left.left= new Node(8);
		root.left.left.right= new Node(9);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		
		traverseInZigZagOrder(root);
	}

	private static void traverseInZigZagOrder(Node root) {
		Stack<Node> s1= new Stack<>();
		Stack<Node> s2= new Stack<>();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				Node s= s1.pop();
				System.out.print(s.data+" ");
				if(s.left!= null) s2.push(s.left);
				if(s.right!= null) s2.push(s.right);
			}
			
			while(!s2.isEmpty()) {
				Node s= s2.pop();
				System.out.print(s.data+" ");
				if(s.left!= null) s1.push(s.right);
				if(s.right!= null) s1.push(s.left);
			
			}
		}
	}

}

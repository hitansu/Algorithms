package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintBottomToTop {

	/**		1
	 *   2		3
	 * 4  5       6
	 * 			7	8
	 * * @param args
	 */
	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.right= new Node(6);
		root.right.right.left= new Node(7);
		root.right.right.right= new Node(8);
		
		printBottomToTop(root);
	}

	private static void printBottomToTop(Node root) {
		Queue<Node> q= new LinkedList<>();
		Stack<Node> s= new Stack<>();
		q.add(root);
		s.push(root);
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.right!= null) {
				q.add(node.right);
				s.push(node.right);
			}
			
			if(node.left!= null) {
				q.add(node.left);
				s.push(node.left);
			}
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop().data+" ");
		}
	}
}

package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SuperImpose2Tree {

	public static void main(String[] args) {
		Node root1= new Node(9);
		root1.left= new Node(3);
		root1.right= new Node(5);
		root1.left.left= new Node(2);
		root1.right.left= new Node(4);
		root1.right.right= new Node(6);
		
		Node root2= new Node(7);
		root2.left= new Node(3);
		root2.right= new Node(8);
		root2.right.left= new Node(1);
		root2.right.left.right= new Node(5);
		
		Node newRoot = superImpose(root1, root2);
		traverse(newRoot);
		System.out.println("\n========================");
		traverse(superImposeRecur(root1, root2));
	}
	
	private static void traverse(Node newRoot) {

		Queue<Node> q1= new LinkedList<Node>();
		q1.add(newRoot);
		
		while(!q1.isEmpty()) {
			Node n1= q1.poll();	
			System.out.print(n1.data+" ");
			if(n1.left!= null ) {
				q1.add(n1.left);
			}
			if(n1.right!= null) {
				q1.add(n1.right);
			}
		}	
	}

	private static Node superImpose(Node root1, Node root2) {
		Queue<Node> q1= new LinkedList<Node>();
		Queue<Node> q2= new LinkedList<Node>();
		q1.add(root2);
		q2.add(root1);
		
		while(!q1.isEmpty()) {
			Node n1= q1.poll();
			Node n2= q2.poll();
			
			if(n1.left== null && n2!= null && n2.left!= null) {
				n1.left= new Node(n2.left.data);
			}
			if(n1.left!= null) {
				q1.add(n1.left);
			}
			if(n2!= null && n2.left!= null) q2.add(n2.left);
			if(n1.right== null && n2!= null && n2.right!= null) {
				n1.right= new Node(n2.right.data);
			}
			if(n1.right!= null) {
				q1.add(n1.right);
			}
			if(n2!= null && n2.right!= null) q2.add(n2.right);
		}
		
		return root2;
	}
	
	private static Node superImposeRecur(Node root1, Node root2) {
		if(root1== null) return root2;
		if(root2== null) return root1;
		root2.left= superImposeRecur(root1.left, root2.left);
		root2.right= superImposeRecur(root1.right, root2.right);
		return root2;
	}

}

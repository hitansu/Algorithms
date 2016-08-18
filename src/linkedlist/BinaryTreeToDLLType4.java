package linkedlist;

import tree.Node;

public class BinaryTreeToDLLType4 {

	static Node head= null;
	static Node prev= null;
	
	public static void main(String[] args) {

		Node root= new Node(10);
		root.left= new Node(12);
		root.left.left= new Node(25);
		root.left.right= new Node(30);
		root.right= new Node(15);
		root.right.left= new Node(36);
		convert(root);
		Node curr= head;
		Node tail= null;
		while(curr!= null) {
			System.out.print(curr.data+" ");
			if(curr.right== null) {
				tail= curr;
			}
			curr= curr.right;
		}
		System.out.println("");
		
		Node currtail= tail;
		while(currtail!= null) {
			System.out.print(currtail.data+" ");
			currtail= currtail.left;
		}
		
		
	}
	
	private static void convert(Node root) {
		if(root== null) {
			return;
		}
		convert(root.left);
		if(head== null) {
			head= root;
		} else {
			prev.right= root;
			root.left= prev;
		}
		prev= root;
		convert(root.right);
	}

}

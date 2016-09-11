package tree;

public class LinkNodeAtSameLevel {

	public static void main(String[] args) {
		Node root= new Node(10);
		root.left= new Node(8);
		root.left.left= new Node(3);
		root.right= new Node(2);
		root.right.right= new Node(90);
		
		root.next= null;
		
		link(root);
		
		System.out.println("Next of 3:: "+root.left.left.next.data);
		System.out.println("Next of 10:: "+(root.next== null?"NA":root.next.data));
		System.out.println("Next of 8:: "+(root.left.next== null?"NA":root.left.next.data));
		System.out.println("Next of 2:: "+(root.right.next== null?"NA":root.right.next.data));
		System.out.println("Next of 90:: "+(root.right.right.next== null?"NA":root.right.right.next.data));

	}
	
	private static void link(Node root) {
		if(root== null) return;
		if(root.left!= null) {
			Node tmp= null;
			if(root.right!= null)
				tmp= root.right;
			else if(root.next!= null && root.next.left!= null)
				tmp= root.next.left;
			else
				tmp= root.next== null?null:root.next.right;
			root.left.next= tmp;
		}
		if(root.right!= null) {
			Node tmp= null;
			if(root.next!= null && root.next.left!= null)
				tmp= root.next.left;
			else
				tmp= root.next== null?null:root.next.right;
			root.right.next= tmp;
		}
		link(root.left);
		link(root.right);
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node next;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

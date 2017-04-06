package tree;

public class CloneBinaryTreeWithRandomPointer1 {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.left.right.random= root.right;
		root.random= root.left.right;
		
		traverse(root);
		System.out.println("");
		System.out.println("****************** \n");
		
		Node cloneRoot= cloneRoot(root);
		
		root.left.left.data= 9;
		
		traverse(cloneRoot);
		System.out.println("\nafter modification");
		traverse(root);
		
	}

	static Node cloneRoot(Node root) {
		Node clonedRoot = cloneLeft(root);
		copyRandom(root, clonedRoot);
		removeLinks(root, clonedRoot);
		return clonedRoot;
	}
	
	static Node cloneLeft(Node root) {
		if(root== null)
			return null;
		Node left= root.left;
		Node clone= new  Node(root.data);
		root.left= clone;
		clone.left= left;
		if(left!= null)
			clone.left.left= cloneLeft(left);
		clone.right= cloneLeft(root.right);
		return clone;
	}
	
	static void copyRandom(Node root, Node clone) {
		if(root== null || clone== null)
			return;
		if(root.random!= null)
			clone.random= root.random.left;
		else
			clone.random= null;
		if(root.left!= null && clone.left!= null)
			copyRandom(root.left.left, clone.left.left);
		copyRandom(root.right, clone.right);
	}
	
	static void removeLinks(Node root, Node clone) {
		if(root== null || clone== null)
			return;
		Node left= clone.left;
		if(left!= null) {
			clone.left= clone.left.left;
			root.left= left;
		} else {
			root.left= null;
			clone.left= null;
		}
		removeLinks(root.left, clone.left);
		removeLinks(root.right, clone.right);
	}
	
	static void traverse(Node root) {
		if(root== null) return;
		if(root.random== null)
		  System.out.print(root.data+" ");
		else 
		  System.out.print(root.data+ "->"+root.random.data+" ");
		traverse(root.left);
		traverse(root.right);
	}

	static class Node {
		int data;
		Node left, right, random;
		
		public Node(int data) {
			this.data= data;
		}
	}
}

package tree;

public class CloneBinaryTreeWithRandomPointer {

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
		
	}

	private static void traverse(Node root) {
		if(root== null) return;
		if(root.random== null)
		  System.out.print(root.data+" ");
		else 
		  System.out.print(root.data+ "->"+root.random.data+" ");
		traverse(root.left);
		traverse(root.right);
	}

	private static Node cloneRoot(Node root) {
		if(root== null)
			return null;
		Node intermediateRoot= copyLeftChild(root);
		traverse(root);
		System.out.println("\n");
		copyRandomNode(root, intermediateRoot);
		removeLink(root, intermediateRoot);
		return intermediateRoot;
	}
	


	private static void removeLink(Node root, Node intermediateRoot) {
		if(root== null)
			return;
		if(intermediateRoot.left!= null) {
			Node left= intermediateRoot.left.left;
			root.left= root.left.left;
			intermediateRoot.left= left;
		} else {
			root.left= null;
		}
		
		removeLink(root.left, intermediateRoot.left);
		removeLink(root.right, intermediateRoot.right);
		
	}

	private static void copyRandomNode(Node root, Node cloneRoot) {
		if(root== null)
			return;
		if(root.random== null)
			cloneRoot.random= null;
		else 
			cloneRoot.random= root.random.left;
		if(root.left!= null && cloneRoot.left!= null)
			copyRandomNode(root.left.left, cloneRoot.left.left);
		copyRandomNode(root.right, cloneRoot.right);
		
	}

	private static Node copyLeftChild(Node root) {
		if(root== null) return null;
		Node clone= new Node(root.data);
		Node left= root.left;
		root.left= clone;
		clone.left= left;
		if(left!= null)
			left.left= copyLeftChild(left);
		clone.right= copyLeftChild(root.right);
		return clone;
		
	}
	
	static class Node {
		
		int data;
		Node left, right, random;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

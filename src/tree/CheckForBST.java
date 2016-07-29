package tree;

public class CheckForBST {

	static Node prev= null;
	
	public static void main(String[] args) {
		Node root= new Node(4);
		root.left= new Node(2);
		root.right= new Node(5);
		root.left.left= new Node(1);
		root.left.right= new Node(3);
		root.right= new Node(5);
		
		System.out.println(isBST(root));
		
		System.out.println(isBST2(root));
	}
	
	private static boolean isBST(Node root) {
		if(root== null) return true;
		if(!isBST(root.left)) return false;
		if(prev!= null && prev.data>root.data) return false;
		prev= root;
		return isBST(root.right);
	}
	
	private static boolean isBST2(Node root) {
		if(root== null) return true;
		Node l= root.left;
		Node r= root.right;
		if(l!= null && l.data>root.data) return false;
		if(r!= null && r.data<root.data) return false;
		return (isBSTUtil(l, Integer.MIN_VALUE, root.data) && isBSTUtil(r, root.data, Integer.MAX_VALUE));
	}

	private static boolean isBSTUtil(Node root, int min, int max) {
		if(root== null) return true;
		if(root.data<min || root.data>max) return false;
		return(isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data, max));
		
	}

}

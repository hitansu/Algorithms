package tree;

public class LowestCommonAncestor {

	/**
	 *      1
	 *   2      3
	 * 4   5   6   7 
	 *    
	 * @param args
	 */
	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		
		LowestCommonAncestor prob= new LowestCommonAncestor();
		Node lca= prob.findLCA(root, 4, 5);
		System.out.println("Lowest Common Ancestor of 4,5:: "+lca.data);
		System.out.println("Lowest Common Ancestor of 4,6:: "+prob.findLCA(root, 4, 6).data);
		System.out.println("Lowest Common Ancestor of 3,4:: "+prob.findLCA(root, 3, 4).data);
		System.out.println("Lowest Common Ancestor of 2,4:: "+prob.findLCA(root, 2, 4).data);
	}

	private Node findLCA(Node root, int a, int b) {
		if(root== null || root.data== a || root.data== b) {
			return root;
		}
		Node left= findLCA(root.left, a, b);
		Node right= findLCA(root.right, a, b);
		if(left!= null & right!= null) {
			return root;
		}
		if(left== null) return right;
		else return left;
	}

}

package tree;

public class CloneBinaryTree {

	public static void main(String[] args) {
		
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(1);
		root.left.right= new Node(1);
		root.right.left= new Node(1);
		root.right.right= new Node(1);
		
		Node cloneRoot= cloneBinaryTree(root);
		traverse(root);
		System.out.println("****************");
		//now change the old tree to check if cloned tree is affected or not.Cloned tree shud not affected
		root.left.data= 8;
		traverse(root);
		System.out.println("");
		traverse(cloneRoot);

	}

	private static void traverse(Node cloneRoot) {
		if(cloneRoot== null) return;
		System.out.print(cloneRoot.data+" ");
		traverse(cloneRoot.left);
		traverse(cloneRoot.right);
		
	}

	private static Node cloneBinaryTree(Node root) {
		if(root== null) return null;
		Node cloneRoot= new Node(root.data);
		cloneRoot.left= cloneBinaryTree(root.left);
		cloneRoot.right= cloneBinaryTree(root.right);
		return cloneRoot;
	}

}

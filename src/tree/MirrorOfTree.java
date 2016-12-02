package tree;

/**
 * 
 * @author hitansu
 *
 */
public class MirrorOfTree {

	public static void main(String[] args) {

	        Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        
	        Node mirroredRoot= getMirrorTree(root);
	        traverse(mirroredRoot);
	}
	
	static void traverse(Node root) {
		if(root== null)
			return;
		System.out.println(root.data);
		traverse(root.left);
		traverse(root.right);
	}
	
	static Node getMirrorTree(Node root) {
		if(root== null)
			return null;
		Node left= getMirrorTree(root.left);
		Node right= getMirrorTree(root.right);
		root.left= right;
		root.right= left;
		return root;
	}

}

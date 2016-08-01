package tree;

public class FindDeepestLeafNode {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.right.left= new Node(5);
		root.right.right= new Node(6);
		root.right.right.right= new Node(8);
		root.right.right.right.right= new Node(10);
		root.right.left.right= new Node(7);
		root.right.left.right.left= new Node(9);
		DeepestNode deepestNode1 = findDeepestNode(root, 1);
		DeepestNode deepestNode2 = findDeepestNode(root, 1, false);
		
		System.out.println("Deepest Node is - "+ deepestNode1.node.data +" & level is - "+deepestNode1.level );
		System.out.println("Deepest Node is - "+ deepestNode2.node.data +" & level is - "+deepestNode2.level );

	}
	
	private static DeepestNode findDeepestNode(Node root, int level) {
		if(root== null) return new DeepestNode(root, 0);
		if(root.left!= null && root.left.left== null && root.left.right== null) return new DeepestNode(root.left, level+1);
		DeepestNode max= new DeepestNode(null, Integer.MIN_VALUE);
		DeepestNode dl = findDeepestNode(root.left, level+1);
		DeepestNode dr = findDeepestNode(root.right, level+1);
		if(dl.level> max.level) {
			max= dl;
		}
		if(dr.level> max.level) {
			max= dr;
		}
		return max;
	}
	
	private static DeepestNode findDeepestNode(Node root, int level, boolean isLeft) {
		if(root== null) return new DeepestNode(root, 0);
		if(isLeft && root.left== null && root.right== null) return new DeepestNode(root, level);
		DeepestNode max= new DeepestNode(null, Integer.MIN_VALUE);
		DeepestNode dl = findDeepestNode(root.left, level+1, true);
		DeepestNode dr = findDeepestNode(root.right, level+1, false);
		if(dl.level> max.level) {
			max= dl;
		}
		if(dr.level> max.level) {
			max= dr;
		}
		return max;
	}

	static class DeepestNode {
		Node node;
		int level;
		
		public DeepestNode(Node node, int level) {
			this.node= node;
			this.level= level;
		}
	}
}

package tree;

public class FindDeepestNode {

	public static void main(String[] args) {

		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.right.left= new Node(4);
		root.right.right= new Node(5);
		
		root.left.right= new Node(6);
		root.left.right.right= new Node(7);
		root.left.right.right.left= new Node(12);
		root.left.right.right.right= new Node(8);
		root.left.right.right.right.right= new Node(10);
		
		System.out.println("Deepest node:: "+findDeepestNode(root, 1).data);
	}
	
	private static DeepNode findDeepestNode(Node root, int level) {
		if(root== null) return new DeepNode(-100, -1);
		DeepNode maxDeepNode= new DeepNode(root.data, level);
		DeepNode lNode= findDeepestNode(root.left, level+1);
		DeepNode rNode= findDeepestNode(root.right, level+1);
		if(maxDeepNode.level<lNode.level) {
			maxDeepNode= lNode;
		}
		if(maxDeepNode.level<rNode.level) {
			maxDeepNode= rNode;
		}
		
		return maxDeepNode;
	}
	
	static class DeepNode {
		int level;
		int data;
		public DeepNode(int data, int level) {
			this.data= data;
			this.level= level;
		}
	}

}

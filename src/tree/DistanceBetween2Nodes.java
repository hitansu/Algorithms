package tree;

public class DistanceBetween2Nodes {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.left.right= new Node(8);
		root.right.right= new Node(7);
		
		System.out.println(findDistanceBetween2Nodes(root, 4, 5));
		
		System.out.println(findDistanceBetween2Nodes(root, 4, 6));
		
		System.out.println(findDistanceBetween2Nodes(root, 3, 4));
		
		System.out.println(findDistanceBetween2Nodes(root, 2, 4));
		
		System.out.println(findDistanceBetween2Nodes(root, 8, 5));
		
	}
	
	private static int findDistanceBetween2Nodes(Node root, int a, int b) {
		Node lca= findLCA(root, a, b);
		int dist1= findRootToNodeDistance(root, a);
		int dist2= findRootToNodeDistance(root, b);
		int distComm= findRootToNodeDistance(root, lca.data);
		return (dist1)+(dist2)-2*(distComm);
	}
	
	private static Node findLCA(Node root, int a, int b) {
		if(root== null || root.data== a || root.data== b) return root;
		Node left= findLCA(root.left, a, b);
		Node right= findLCA(root.right, a, b);
		if(left!= null && right!= null) return root;
		if(left== null) return right;
		else return left;
	}
	
	private static int findRootToNodeDistance(Node root, int a) {
		int dist= -1;
		if(root== null) return dist;
		if(root.data== a) return 0;
		dist= findRootToNodeDistance(root.left, a);
		if(dist<0) {
			dist= findRootToNodeDistance(root.right, a);
		}
		
		if(dist>= 0) {
			dist= dist+1;
		}
		return dist;
	}

}

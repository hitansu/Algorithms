package tree;

public class CheckIfSumTree {

	public static void main(String[] args) {
		Node root= new Node(26);
		root.left= new Node(10);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(6);
		root.right.right= new Node(3);
		
		int status = checkSumTree(root);
		if(status== Integer.MIN_VALUE)
			System.out.println("Its not a sum tree");
		else if(status== 2*root.data)
			System.out.println("Its a sum tree");
		
	}
	
	static int checkSumTree(Node root) {
		if(root== null) return 0;
		if(root.left== null && root.right== null) return root.data;
		int left= checkSumTree(root.left);
		if(left== Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int right= checkSumTree(root.right);
		if(right== Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if(left+right!= root.data) return Integer.MIN_VALUE;
		return left+right+root.data;
	}
}

package tree;

public class SumOfChildNodes {

	/**
	 *              1
                 /      \
                2        3
              /  \        \
             4   5        8
                        /    \
                       6       7
	 * @param args
	 */
	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.right= new Node(8);
		root.right.right.left= new Node(6);
		root.right.right.right= new Node(7);
		
		SumOfChildNodes prob= new SumOfChildNodes();
		int tmp= root.data;
		int childSum = prob.findChildSum(root);
		System.out.println(childSum-tmp);
	}

	private int findChildSum(Node root) {
		if(root== null) return 0;
		if(root.left== null && root.right== null) {
			return root.data;
		}
		int left= findChildSum(root.left);
		int right= findChildSum(root.right);
		int tmp= root.data;
		root.data= left+right;
		return root.data+tmp;
	}

}
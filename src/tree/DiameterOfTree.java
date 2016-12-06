package tree;

public class DiameterOfTree {

	public static void main(String[] args) {
		    Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        
	        int diameter= findDiameter(root);
	        System.out.println(diameter);
	 
	}
	
	private static int findDiameter(Node root) {
		int[] result= findDiameterUtil(root);
		return result[1];
	}

	private static int[] findDiameterUtil(Node root) {
		int[] result= new int[2];
		if(root== null) {
			result[0]= 0;
			result[1]= 0;
			return result;
		}
		int[] lh= findDiameterUtil(root.left);
		int[] rh= findDiameterUtil(root.right);
		int height= Math.max(lh[0], rh[0])+1;
		int maxDiameterOfChilds= Math.max(lh[1], lh[1]);
		int diameter= Math.max(maxDiameterOfChilds, lh[0]+rh[0]+1);
		result[0]= height;
		result[1]= diameter;
		return result;
	}
}

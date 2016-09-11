package tree;

public class ConstructTreeFromPrePost {

	public static void main(String[] args) {
		int[] pre= {1, 2, 4, 8, 9, 5, 3, 6, 7};
		int[] post= {8, 9, 4, 5, 2, 6, 7, 3, 1};
		
		Node root= getTree(pre, post);
		printTree(root);
		
		System.out.println("");
		Node root2= getTreeRec(pre, post, 0, pre.length-1, pre.length);
		printTree(root2);

	}

	private static void printTree(Node root) {
		if(root== null) return;
		System.out.print(root.data+" ");
		printTree(root.left);
		printTree(root.right);
		
	}
	
	static int preIndex= 0;
	private static Node getTreeRec(int[] preorder, int[] postorder, int l, int h, int size) {
		if(preIndex>size) return null;
		if(l>h) return null;
		int data= preorder[preIndex];
		preIndex++;
		Node root= new Node(data);
		if(l== h || preIndex>=size) return root;
		int index= getIndex(preorder[preIndex], postorder);
		if(index<0 || index>h) return root;
		root.left= getTreeRec(preorder, postorder, l, index, size);
		root.right= getTreeRec(preorder, postorder, index+1, h, size);
		
		return root;
	}

	private static Node getTree(int[] pre, int[] post) {
		if(pre.length!= post.length) throw new IllegalArgumentException("Should be same length");
		int l= pre.length;
		int[] tree= new int[l];
		int data= pre[0];
		int i= 0;
		int j= 0;
		tree[j]= data;
		while(true) {
			int left= pre[getIndex(data, pre)+1];
			int right= post[getIndex(data, post)-1];
			j++;
			if(j<l)
			 tree[j]= left;
			j++;
			if(j<l)
			 tree[j]= right;
			if(j>= l-1) break;
			i++;
			data= tree[i];
		}
		
		
		
		return buildTree(tree, 0);
	}

	private static Node buildTree(int[] tree, int i) {
		if(i>= tree.length) return null;
		Node root= new Node(tree[i]);
		Node left= buildTree(tree, 2*i+1);
		Node right= buildTree(tree, 2*i+2);
		root.left= left;
		root.right= right;
		
		return root;
	}

	private static int getIndex(int data, int[] arr) {
		int l= arr.length;
		for(int i= 0;i<l;i++) {
			if(arr[i]== data) return i;
		}
		return -1;
	}

}

package heap;

public class HeapCheck {

	public static void main(String[] args) {
		
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);
        
        boolean isMaxHeap= isMaxHeap(root);
        System.out.println("Is heap: "+isMaxHeap);

	}
	
	private static boolean isMaxHeap(Node root) {
		int node_count= countNode(root);
		if(isCompleteTree(root,0,node_count)) {
			return isHeap(root);
		}
		return false;
	}

	private static boolean isHeap(Node root) {
		if(root== null)
			return true;
		if(root.left== null && root.right== null)
			return true;
		if(root.right== null)
			return root.data>=root.left.data;
		
		if(root.data>= root.left.data && root.data>= root.right.data) {
			if(isHeap(root.left) && isHeap(root.right)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	private static boolean isCompleteTree(Node root, int index, int count) {
		if(root== null)
			return true;
		if(index>=count)
			return false;
		if(isCompleteTree(root.left, 2*index+1, count) && isCompleteTree(root.right, 2*index+2, count)) {
			return true;
		} else {
			return false;
		}
	}

	private static int countNode(Node root) {
		if(root== null)
			return 0;
		return 1+countNode(root.left)+countNode(root.right);
	}

	static class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data= data;
		}
		
	}

}

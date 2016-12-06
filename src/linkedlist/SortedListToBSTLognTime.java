package linkedlist;

public class SortedListToBSTLognTime {

	Node curr;
	public static void main(String[] args) {
		SortedListToBSTLognTime sol= new SortedListToBSTLognTime();
		sol.solve();
	}
	
	public void solve() {
		Node head= new Node(1);
		head.right= new Node(4);
		head.right.right= new Node(8);
		head.right.right.right= new Node(12);
		head.right.right.right.right= new Node(16);
		head.right.right.right.right.right= new Node(20);
		head.right.right.right.right.right.right= new Node(24);
		
		curr= head;
		Node root= convertLinkedListToBST(getSize(head));
		traverseTree(root);
	
	}
	
	private void traverseTree(Node root) {
		if(root== null)
			return;
		traverseTree(root.left);
		System.out.print(root.data+" ");
		traverseTree(root.right);	
	}

	private Node convertLinkedListToBST(int size) {
		if(size<= 0)
			return null;
		
		Node left= convertLinkedListToBST(size/2);
		Node root= new Node(curr.data);
		curr= curr.right;
		Node right= convertLinkedListToBST(size-(size/2)-1);
		root.left= left;
		root.right= right;
		
		return root;
	}

	private int getSize(Node head) {
		int size= 0;
		Node curr= head;
		while(curr!= null) {
			size++;
			curr= curr.right;
		}
		return size;
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

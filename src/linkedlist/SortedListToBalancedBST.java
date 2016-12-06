package linkedlist;

public class SortedListToBalancedBST {

	public static void main(String[] args) {
		
		Node head= new Node(1);
		head.right= new Node(4);
		head.right.right= new Node(8);
		head.right.right.right= new Node(12);
		head.right.right.right.right= new Node(16);
		head.right.right.right.right.right= new Node(20);
		head.right.right.right.right.right.right= new Node(24);
		
		
		Node root= convertLinkedListToBST(head, getSize(head));
		traverseTree(root);

	}
	
	private static int getSize(Node head) {
		int size= 0;
		Node curr= head;
		while(curr!= null) {
			size++;
			curr= curr.right;
		}
		return size;
	}

	private static void traverseTree(Node root) {

		if(root== null)
			return;
		traverseTree(root.left);
		System.out.print(root.data+" ");
		traverseTree(root.right);
	}

	private static Node convertLinkedListToBST(Node head, int size) {
		if(size<=0)
			return null;
		Node mid= findMid(head, size);
		Node nextHalf= mid.right;
		
		Node root= new Node(mid.data);
		int leftsize= 0;
		if(size%2== 0) 
			leftsize= size/2;
		else
			leftsize= (size-1)/2;
		root.left= convertLinkedListToBST(head, leftsize);
		root.right= convertLinkedListToBST(nextHalf, size-size/2-1);
		return root;
	}

	private static Node findMid(Node head, int size) {
		int mid_size= 0;
		if(size%2== 0) {
			mid_size= (size/2)-1;
		} else {
			mid_size= (size-1)/2;
		}
		int count= 0;
		Node mid= head;
		while(count!= mid_size) {
			mid= mid.right;
			count++;
		}
		return mid;
	}

	static class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

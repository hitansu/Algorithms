package linkedlist;

public class TreeToDLL {

	static Node head= null;
	static Node prev= null;
	
	class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data= data;
			this.left= this.right= null;
		}
	}
	
	public static void main(String[] args) {
		TreeToDLL problem= new TreeToDLL();
		problem.solve();
	}
	
	private void solve() {
		Node root= new Node(10);
		root.left= new Node(12);
		root.right= new Node(15);
		root.left.left= new Node(25);
		root.right.left= new Node(36);
		root.left.right= new Node(30);
		
		treeToDLL(root);
		while(head!= null) {
			System.out.print(head.data+" ");
			head= head.right;
		}
	}
	
	private void treeToDLL(Node root) {
		
		if(root== null) return ;
		treeToDLL(root.left);
		if(head== null) {
			head= root;
		} else {
			root.left= prev;
			if(prev!= null) {
				prev.right= root;
			}
		}
		
		prev= root;
		treeToDLL(root.right);
		
	}
}

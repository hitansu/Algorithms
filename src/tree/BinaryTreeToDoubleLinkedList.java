package tree;

/**
 * Same as converting tree to doubly linkedlist.In the end just have to link head & tail.
 * @author jenah
 *
 */
public class BinaryTreeToDoubleLinkedList {

	Node head= null;
	Node tail= null;
	public static void main(String[] args) {

		BinaryTreeToDoubleLinkedList problem= new BinaryTreeToDoubleLinkedList();
		
		Node root= new Node(10);
		root.left= new Node(12);
		root.right= new Node(15);
		root.left.left= new Node(25);
		root.left.right= new Node(30);
		root.right.left= new Node(36);
		
		Node head= problem.getCircularDoublyLinkedlist(root);
		
		problem.print(head);
		
	}

	private void print(Node head) {
		Node curr= head;
		while(true) {
			System.out.print(curr.data+" ");
			curr= curr.right;
			if(curr== head) break;
		}
		
	}

	private Node getCircularDoublyLinkedlist(Node root) {
		
		convertToDoublyLinkedlist(root);
		head.left= tail;
		tail.right= head;
		
		return head;
	}

	private void convertToDoublyLinkedlist(Node root) {
		if(root== null) return;
		
		convertToDoublyLinkedlist(root.left);
		if(head== null) {
			head= root;
			head.left= null;
		} else {
			tail.right= root;
			root.left= tail;
		}
		tail= root;
		
		convertToDoublyLinkedlist(root.right);
		
	}

}

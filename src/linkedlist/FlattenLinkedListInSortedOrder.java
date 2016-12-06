package linkedlist;

public class FlattenLinkedListInSortedOrder {

	public static void main(String[] args) {
		
		Node head= new Node(5);
		head.down= new Node(7);
		head.down.down= new Node(8);
		head.down.down.down= new Node(30);
		
		head.right= new Node(10);
		head.right.down= new Node(20);
		
		head.right.right= new Node(19);
		head.right.right.down= new Node(22);
		head.right.right.down.down= new Node(50);
		
		
		head.right.right.right= new Node(28);
		head.right.right.right.down= new Node(35);
		head.right.right.right.down.down= new Node(40);
		head.right.right.right.down.down.down= new Node(45);
		
		Node flattenHead= flattenList(head);
		Node curr= flattenHead;
		while(curr!= null) {
			System.out.print(curr.data+" ");
			curr= curr.down;
		}

	}
	
	private static Node flattenList(Node head) {
		if(head== null || head.right== null)
			return head;
		
		head.right= flattenList(head.right);
		Node rootHead= merge(head, head.right);
		return rootHead;
	}

	private static Node merge(Node head1, Node head2) {
		if(head1== null)
			return head2;
		if(head2== null)
			return head1;
		if(head1.data<head2.data) {
			head1.down= merge(head1.down, head2);
			return head1;
		} else {
			head2.down= merge(head1, head2.down);
			return head2;
		}
	}

	static class Node {
		Node right;
		Node down;
		int data;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

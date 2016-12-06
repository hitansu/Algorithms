package linkedlist;

public class ReverseSingleLinkedList {

	Node head;
	Node revHead;
	public static void main(String[] args) {

		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next= new Node(5);
		
		ReverseSingleLinkedList sol= new ReverseSingleLinkedList();
		sol.solve(head);
	}
	private void solve(Node head2) {
		reverse(head2);
		
		Node curr= head;
		while(curr!= null) {
			System.out.print(curr.data+" ");
			curr= curr.next;
		}
		
	}
	private void reverse(Node head2) {
		if(head2== null)
			return;
		Node next= head2.next;
		if(next== null)
			return;
		reverse(next);
		head2.next.next= head2;
		head2.next= null;
		if(head== null)
			head= next;
	}

}

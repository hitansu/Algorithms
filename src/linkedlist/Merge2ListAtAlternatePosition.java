package linkedlist;

public class Merge2ListAtAlternatePosition {

	public static void main(String[] args) {

		Node head1= new Node(5);
		head1.next= new Node(7);
		head1.next.next= new Node(17);
		head1.next.next.next= new Node(13);
		head1.next.next.next.next= new Node(11);
		
		Node head2= new Node(12);
		head2.next= new Node(10);
		head2.next.next= new Node(2);
		head2.next.next.next= new Node(4);
		head2.next.next.next.next= new Node(6);
		
	//	head2 = mergeAlternatively(head1, head2);
		head2= mergeAlternativelyRec(head1, head2);
		Node curr= head1;
		while(curr!= null) {
			System.out.print(curr.data+" ");
			curr= curr.next;
		}
		System.out.println("");
		if(head2!= null)
			System.out.println(head2.data);
	}
	
	private static Node mergeAlternatively(Node head1, Node head2) {
		Node curr1= head1;
		Node curr2= head2;
		
		while(curr1!= null && curr2!= null) {
			Node next1= curr1.next;
			Node next2= curr2.next;
			curr1.next= curr2;
			curr2.next= next1;
			curr2= next2;
			curr1= next1;
		}
		head2= curr2;
		return head2;
	}
	
	private static Node mergeAlternativelyRec(Node head1, Node head2) {
		if(head1== null || head2== null) {
			return head2;
		}
		Node n1= head1.next;
		Node n2= head2.next;
		head1.next= head2;
		head2.next= n1;
	    return mergeAlternativelyRec(n1, n2);
	}

}

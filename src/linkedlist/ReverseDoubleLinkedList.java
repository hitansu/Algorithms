package linkedlist;

public class ReverseDoubleLinkedList {

	public static void main(String[] args) {
		Node head= new Node(10);
		head.next= new Node(8);
		head.prev= null;
		
		head.next.next= new Node(4);
		head.next.prev= head;
		head.next.next.prev= head.next;
		
		head.next.next.next= new Node(2);
		head.next.next.next.prev= head.next.next;
		head.next.next.next.next= null;
		
		Node currBefore= head;
		while(currBefore!= null) {
			System.out.print(currBefore.data+" ");
			currBefore= currBefore.next;
		}
/*		
		Node headNew= reverse(head);
		Node currAfter= headNew;
		System.out.println("\n after reverse");
		while(currAfter!= null) {
			System.out.print(currAfter.data+" ");
			currAfter= currAfter.next;
		}*/
		
		Node headNewRec= reverseRec(head);
		Node currAfterRec= headNewRec;
		System.out.println("\nafter reverse recursion");
		while(currAfterRec!= null) {
			System.out.print(currAfterRec.data+" ");
			currAfterRec= currAfterRec.next;
		}
		
		
	}
	
	private static Node reverseRec(Node head) {
		return reverseRec(null, head);
	}
	
	private static Node reverseRec(Node prev, Node curr) {
		if(curr== null) return prev;
		Node head= reverseRec(curr, curr.next);
		curr.next= prev;
		if(prev!= null)
			prev.prev= curr;
		return head;
	}

	private static Node reverse(Node head) {

		Node prev= null;
		Node curr= head;
		while(curr!= null) {
			Node tmp= curr.next;
			curr.next= prev;
			curr.prev= tmp;
			prev= curr;
			curr= tmp;
		}
		return prev;
	}

}

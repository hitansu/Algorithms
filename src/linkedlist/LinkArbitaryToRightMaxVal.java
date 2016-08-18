package linkedlist;

public class LinkArbitaryToRightMaxVal {

	public static void main(String[] args) {

		Node head= new Node(5);
		head.next= new Node(10);
		head.arb= null;
		head.next.next= new Node(2);
		head.next.arb= null;
		head.next.next.next= new Node(3);
		head.next.next.arb= null;
		
		linkArbitary(head);
		
		Node curr= head;
		while(curr!= null) {
			System.out.print(curr.arb== null?0:curr.arb.data+" ");
			curr= curr.next;
		}
	}
	
	static Node max= null;
	static int MAX= Integer.MIN_VALUE;
	
	private static void linkArbitary(Node head) {
		if(head== null) {
			return;
		}
		linkArbitary(head.next);
		if(max!= null) {
			head.arb= max;
		}
		if(MAX< head.data) {
			MAX= head.data;
			max= head;
		}
	}
	

	static public class Node {
		Node next;
		Node arb;
		int data;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

package linkedlist;

public class DetectLoop {

	public static void main(String[] args) {
		
		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next= new Node(5);
		head.next.next.next.next.next= new Node(6);
		head.next.next.next.next.next.next= new Node(7);
		head.next.next.next.next.next.next.next= head.next.next.next;
		boolean isPresent= isLoopPresent(head);
		System.out.println("Is loop present: "+isPresent);
	}

	private static boolean isLoopPresent(Node head) {
		if(head== null) return false;
		Node current= head;
		Node fastPtr= head;
		while(current!= null) {
			if(fastPtr!= null && fastPtr.next!= null) {
				fastPtr= fastPtr.next.next;
			} else return false;
			if(current== fastPtr) return true;
			current= current.next;
		}
		
		return false;
	}

}

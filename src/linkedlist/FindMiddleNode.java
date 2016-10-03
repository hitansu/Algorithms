package linkedlist;

public class FindMiddleNode {

	public static void main(String[] args) {

		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next= new Node(5);
		head.next.next.next.next.next= new Node(6);
		Node midNode= findMiddleNode(head);
		System.out.println("Middle node: "+midNode.data);
	}

	private static Node findMiddleNode(Node head) {
		Node slowPtr= head;
		Node fastPtr= head;
		while(slowPtr!= null && fastPtr!= null && fastPtr.next!= null) {
			slowPtr= slowPtr.next;
			fastPtr= fastPtr.next.next;
		}
		return slowPtr;
	}

}

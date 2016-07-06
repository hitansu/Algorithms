package linkedlist;

public class LinkedList {

	Node head;
	Node curr;
	
	public Node addNode(int data) {
		Node node= new Node();
		node.data= data;
		node.next= null;
		if(head== null) {
			head= node;
			curr= head;
		} else {
			curr.next= node;
			curr= node;
		}
		
		return head;
	}
	
	public static Node createLinkedList(int... elements) {
		LinkedList list= new LinkedList();
		Node listHead= null;
		for(int data: elements) {
			listHead= list.addNode(data);
		}
		return listHead;
		
	}
	
	class Node {
		int data;
		Node next;
	}
}

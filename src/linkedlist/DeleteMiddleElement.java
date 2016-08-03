package linkedlist;

import static linkedlist.LinkedList.createLinkedList;

import linkedlist.LinkedList.Node;

public class DeleteMiddleElement {

	public static void main(String[] args) {
		DeleteMiddleElement del= new DeleteMiddleElement();
		//Node head = del.delMiddleElement(createLinkedList(1,4,6,8,10,15,16));
		Node head = del.delMiddleElement(createLinkedList(1,5,4,6,8,10));
		del.printList(head);
	}

	private void printList(Node head) {
		Node curr= head;
		while(curr!= null) {
			System.out.print(curr.data+" ");
			curr= curr.next;
		}
	}

	private Node delMiddleElement(Node head) {
		Node middle = findMiddleElement(head);
		Node middleNext= middle.next;
		middle.data= middleNext.data;
		middle.next= middleNext.next;
		middleNext.next= null;
		return head;
	}
	
	private Node findMiddleElement(Node head) {
		Node slowPtr= head;
		Node fastPtr= head;
		while(fastPtr!= null && fastPtr.next!= null) {
			fastPtr= fastPtr.next.next;
			slowPtr= slowPtr.next;
		}
		return slowPtr;			
	}
}

package linkedlist;

import static linkedlist.LinkedList.createLinkedList;

import linkedlist.LinkedList.Node;

public class Merge2SortedLinkedList {

	public static void main(String[] args) {
		
		Merge2SortedLinkedList merge= new Merge2SortedLinkedList();
		
		LinkedList l1= new LinkedList();
		LinkedList l2= new LinkedList();
		Node head1 = createLinkedList(4, 7, 9, 14, 15);
		Node head2= createLinkedList(1, 5, 8, 10, 15);
		/*Node head1 = l1.createLinkedList(4, 7);
		Node head2= l2.createLinkedList(1, 5);*/
		Node newhead = merge.merge(head1, head2);
		while(newhead!= null) {
			System.out.print(newhead.data+ " ");
			newhead= newhead.next;
		}
		
		/*Sort n number of linkedlist*/
		
	}
	
	private Node merge(Node head1, Node head2) {
		if(head1== null) {
			return head2;
		}
		
		if(head2== null) {
			return head1;
		}
		
		if(head1.data> head2.data) {
			head2.next= merge(head1, head2.next);
			return head2;
		} else {
			head1.next= merge(head1.next, head2);
			return head1;
		}
	}
}

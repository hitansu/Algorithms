package linkedlist;

import static linkedlist.LinkedList.createLinkedList;

import linkedlist.LinkedList.Node;

public class MergeNLinkedLists {

	public static void main(String[] args) {
		MergeNLinkedLists mergeN= new MergeNLinkedLists();
		Node h1 = createLinkedList(1,2,8,9);
		Node h2 = createLinkedList(0,1,3,4,5);
		Node h3 = createLinkedList(12,40,44,50);
		Node h4 = createLinkedList(12,40,44,50);
		Node h5 = createLinkedList(10,50,60,70);
		
		Node mergeHead = mergeN.mergeNLists(h1, h2, h3, h4, h5);
		while(mergeHead!= null) {
			System.out.print(mergeHead.data+" ");
			mergeHead= mergeHead.next;
		}
	}
	
	Node merge2Lists(Node head1, Node head2) {
		if(head1== null) return head2;
		if(head2== null) return head1;
		
		if(head1.data> head2.data) {
			head2.next= merge2Lists(head1, head2.next);
			return head2;
		} else {
			head1.next= merge2Lists(head1.next, head2);
			return head1;
		}
	}
	
	Node mergeNLists(Node... heads) {
		if(heads.length<1 || heads== null) return null;
		if(heads.length== 1) return heads[0];
		Node mergeHead = merge2Lists(heads[0], heads[1]);
		for (int i= 2;i< heads.length;i++) {
			mergeHead= merge2Lists(mergeHead, heads[i]);
		}
		return mergeHead;
	}
}

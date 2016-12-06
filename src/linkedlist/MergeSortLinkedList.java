package linkedlist;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		
		Node head= new Node(20);
		head.next= new Node(10);
		head.next.next= new Node(2);
		head.next.next.next= new Node(8);
		head.next.next.next.next= new Node(16);
		head.next.next.next.next.next= new Node(18);
		head.next.next.next.next.next.next= new Node(12);
		head.next.next.next.next.next.next.next= new Node(1);
		head.next.next.next.next.next.next.next.next= new Node(3);
		
		Node sortedNode= mergeSort(head);
		Node curr= sortedNode;
		while(curr!= null) {
			System.out.print(curr.data+" ");
			curr= curr.next;
		}

	}

	private static Node mergeSort(Node head) {
		if(head== null || head.next== null)
			return head;
		Node mid= findMid(head);
		Node firstHalf= head;
		Node secondHalf= mid.next;
		mid.next= null;
		
		Node a= mergeSort(firstHalf);
		Node b= mergeSort(secondHalf);
		return merge(a,b);
	}

	private static Node merge(Node a, Node b) {
		if(a== null)
			return b;
		if(b== null)
			return a;
		if(a.data>b.data) {
			b.next= merge(a, b.next);
			return b;
		} else {
			a.next= merge(a.next, b);
			return a;
		}
	}

	private static Node findMid(Node head) {
		Node slowPtr= head;
		Node fastPtr= head.next;
		while(slowPtr!= null && fastPtr!= null && fastPtr.next!= null) {
			slowPtr= slowPtr.next;
			fastPtr= fastPtr.next.next;
		}
		return slowPtr;
	}

}

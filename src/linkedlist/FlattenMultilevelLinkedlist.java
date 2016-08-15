package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenMultilevelLinkedlist {

	public static void main(String[] args) {
		Node head= new Node(10);
		head.down= new Node(4);
		head.down.next= new Node(20);
		head.down.next.down= new Node(2);
		head.down.next.next= new Node(13);
		head.down.next.next.down= new Node(16);
		head.down.next.next.down.down= new Node(3);
		head.next= new Node(5);
		head.next.next= new Node(12);
		head.next.next.next= new Node(7);
		head.next.next.next.next= new Node(11);
		head.next.next.next.down= new Node(17);
		head.next.next.next.down.down= new Node(9);
		head.next.next.next.down.down.down= new Node(19);
		head.next.next.next.down.down.down.next= new Node(15);
		head.next.next.next.down.down.next= new Node(8);
		head.next.next.next.down.next= new Node(6);
		
		Node headNew = flattenList(head, null);
		Node curr= headNew;
		while(curr!= null) {
			System.out.print(curr.data+ " ");
			curr= curr.next;
		}
	}
	
	private static Node flattenList(Node head, Node headNew) {
		if(head== null) return null;
		Queue<Node> q= new LinkedList<>();
		Node currNew= null;
		q.add(head);
		while(!q.isEmpty()) {
			Node n= q.poll();
			while(n!= null) {
				if(headNew== null) {
					headNew= n;
					currNew= n;
				} else {
					currNew.next= n;
					currNew= currNew.next;
				}
				
				if(n.down!= null) {
					q.add(n.down);
				}
				n= n.next;
			}
		}
		currNew.next= null;
		
		return headNew;
	}
}

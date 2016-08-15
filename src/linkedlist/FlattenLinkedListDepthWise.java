package linkedlist;

import java.util.Stack;

public class FlattenLinkedListDepthWise {

	public static void main(String[] args) {

		Node head= new Node(1);
		head.next= new Node(2);
		head.next.down= new Node(7);
		head.next.down.down= new Node(9);
		head.next.down.down.down= new Node(14);
		head.next.down.down.down.down= new Node(15);
		head.next.down.down.down.down.next= new Node(23);
		head.next.down.down.down.down.next.down= new Node(24);
		head.next.down.next= new Node(8);
		head.next.down.next.down= new Node(16);
		head.next.down.next.down.down= new Node(17);
		head.next.down.next.down.down.next= new Node(18);
		head.next.down.next.down.down.next.next= new Node(19);
		head.next.down.next.down.down.next.next.next= new Node(20);
		head.next.down.next.down.down.next.next.next.down= new Node(21);
		head.next.down.next.next= new Node(10);
		head.next.down.next.next.down= new Node(11);
		head.next.down.next.next.next= new Node(12);
		
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		
		
		Node headNew = flatten(head, null);
		Node currNew= headNew;
		while(currNew!= null) {
			System.out.print(currNew.data+" ");
			currNew= currNew.next;
		}
	}
	
	private static Node flatten(Node head, Node headNew) {
		if(head== null) return null;
		Stack<Node> s= new Stack<>();
		s.push(head);
		Node currNew= null;
		while(!s.isEmpty()) {
			Node n= s.pop();
			while(n!= null) {
				if(headNew== null) {
					headNew= n;
					currNew= n;
				} else {
					currNew.next= n;
					currNew= currNew.next;
				}
				if(n.next!= null) {
					s.push(n.next);
				}
				n= n.down;
			}
		}
		currNew.next= null;
		
		return headNew;
	}

}

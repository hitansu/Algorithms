package linkedlist;

public class PairWiseSwapNode {

	public static void main(String[] args) {

		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next= new Node(5);
	//	head.next.next.next.next.next= new Node(6);
		Node curr= head;
		while(curr!= null) {
			System.out.print(curr.data+" ");
			curr= curr.next;
		}
/*		
		Node headNew= doPairwiseSwap(head);
		System.out.println("\nAfter swapping");
		while(headNew!= null) {
			System.out.print(headNew.data+" ");
			headNew= headNew.next;
		}*/		
		Node headNewRec= doPairwiseSwapRec(head);
//		Node headNewRec = doPairwiseSwapRec(head, head.next);
		System.out.println("\nAfter swapping");
		while(headNewRec!= null) {
			System.out.print(headNewRec.data+" ");
			headNewRec= headNewRec.next;
		}
		
	}

	private static Node doPairwiseSwap(Node head) {
		Node tmp= null;
		Node curr= head;
		Node headNew= null;
		if(head== null || head.next== null) return head;
		
		while(curr!= null && curr.next!= null) {
			if(headNew== null) {
				headNew= curr.next;
			}
			tmp= curr.next.next;
			curr.next.next= curr;
			if(tmp== null || tmp.next== null) {
				curr.next= tmp;
				break;
			}
			curr.next= tmp.next;
			curr= tmp;
		}
		return headNew;
	}
	
	private static Node doPairwiseSwapRec(Node curr) {
		if(curr== null || curr.next== null) {
			return curr;
		}
		Node tmp= curr.next;
		curr.next= doPairwiseSwapRec(tmp.next);
		tmp.next= curr;
		return tmp;
	}
	
	private static Node doPairwiseSwapRec(Node curr, Node next) {
		if(next== null) {
			return curr;
		}
		if(next.next== null) {
			next.next= curr;
			curr.next= null;
			return next;
		}
		curr.next= doPairwiseSwapRec(next.next, next.next.next);
		next.next= curr;
		return next;
	}

}

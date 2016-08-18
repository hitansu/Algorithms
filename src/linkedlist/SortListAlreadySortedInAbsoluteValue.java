package linkedlist;

public class SortListAlreadySortedInAbsoluteValue {

	public static void main(String[] args) {

		Node head= new Node(1);
		head.next= new Node(-2);
		head.next.next= new Node(-3);
		head.next.next.next= new Node(4);
		head.next.next.next.next= new Node(-5);
		
		Node headnew = sort(head);
		Node currNew= headnew;
		while(currNew!= null) {
			System.out.print(currNew.data+" ");
			currNew= currNew.next;
		}
	}
	
	private static Node sort(Node head) {
		Node curr= head;
		Node prev= null;
		while(curr!= null) {
			Node tmp= curr.next;
			if(curr.data<0) {
				curr.next= head;
				head= curr;
				if(prev!= null) {
					prev.next= tmp;
				}
			} else {
				prev= curr;
			}
			curr= tmp;
			
		}
		
		return head;
		
	}

}

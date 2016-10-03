package linkedlist;

public class DeleteLoop {

	public static void main(String[] args) {
		
		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next= new Node(5);
		head.next.next.next.next.next= new Node(6);
		head.next.next.next.next.next.next= new Node(7);
		head.next.next.next.next.next.next.next= head.next.next.next;
		deleteLoop(head);
		
		Node curr= head;
		int count= 0;
		while(curr!= null) {
			if(count>20) {
				System.out.println("cant traverse in this way,only comparing null as it has no end.Loop is present.");
			}
			System.out.print(curr.data+" ");
			curr= curr.next;
			count++;
		}

	}

	private static void deleteLoop(Node head) {
		Node meetNode= findLoop(head);
		if(meetNode== null)
			throw new RuntimeException("Loop not present");
		int l= findLoopLength(meetNode);
		// move head by l
		int k= 0;
		Node movedCurr= head;
		while(k<l && movedCurr!= null) {
			movedCurr= movedCurr.next;
			k++;
		}
		Node curr= head;
		Node preLoopNode= null;
		while(curr!= movedCurr) {
			preLoopNode= movedCurr;
			curr= curr.next;
			movedCurr= movedCurr.next;
			
		}
		if(preLoopNode!= null) {
			preLoopNode.next= null;
		}
		
	}

	private static int findLoopLength(Node meetNode) {
		Node curr= meetNode.next;
		int l= 1;
		while(curr!= meetNode) {
			l++;
			curr= curr.next;
		}
		return l;
	}

	private static Node findLoop(Node head) {
		Node curr= head;
		Node fastPtr= head;
		while(curr!= null) {
			if(fastPtr!= null && fastPtr.next!= null) {
				fastPtr= fastPtr.next.next;
			} else 
				return null;
			if(curr== fastPtr)
				return curr;
			curr= curr.next;
		}
		return null;
	}

}

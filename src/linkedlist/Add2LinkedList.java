package linkedlist;

public class Add2LinkedList {

	public static void main(String[] args) {

		Node head1= new Node(9);
		head1.next= new Node(9);
		head1.next.next= new Node(9);
		
		Node head2= new Node(1);
	//	head2.next= new Node(5);
	//	head2.next.next= new Node(5);
		
	//	Node sumHead = addNoWithoutCreatingNewListForResult(head1, head2);
		Node sumHead= addWithCreatingnewListForResult(head1, head2);
		Node curr= sumHead;
		while(curr!= null) {
			System.out.print(curr.data+"");
			curr= curr.next;
		}
	}
	
	private static Node addWithCreatingnewListForResult(Node head1, Node head2) {
		int l1= 0;
		int l2= 0;
		Node curr1= head1;
		while(curr1!= null) {
			l1++;
			curr1= curr1.next;
		}
		Node curr2= head2;
		while(curr2!= null) {
			l2++;
			curr2= curr2.next;
		}
		Node resulthead= null;
		if(l1== l2) {
			 resulthead= addSameLengthList(head1, head2);
		} else if(l1>l2) {
			int diff= l1-l2;
			int c= 0;
			curr1= head1;
			while(c!= diff) {
				++c;
				curr1= curr1.next;
			}
			resulthead= addSameLengthList(curr1, head2);
			resulthead= addCarryToRemaining(head1, curr1, resulthead);
		} else {
			int diff= l2-l1;
			int c= 0;
			curr1= head2;
			while(c!= diff) {
				++c;
				curr1= curr1.next;
			}
			resulthead= addSameLengthList(curr1, head1);
			resulthead= addCarryToRemaining(head2, curr1, resulthead);
		}
		if(gCarry>0) {
			Node result= new Node(gCarry);
			result.next= resulthead;
			resulthead= result;
		}
		return resulthead;
		
	}
	private static Node addCarryToRemaining(Node head1, Node curr1, Node resulthead) {
		if(head1== curr1) {
			return resulthead;
		}
		Node result= new Node(-1);
		result.next= addCarryToRemaining(head1.next, curr1, resulthead);
		int sum= head1.data+gCarry;
		result.data= sum%10;
		gCarry= sum/10;
		return result;
	}
	public static int gCarry= 0;
	private static Node addSameLengthList(Node head1, Node head2) {
		if(head1== null || head2== null) {
			return null;
		}
		Node result= new Node(-1);
		result.next= addSameLengthList(head1.next, head2.next);
		int sum= head1.data+head2.data+gCarry;
		result.data= sum%10;
		gCarry= sum/10;
		return result;
	}

	private static Node addNoWithoutCreatingNewListForResult(Node head1, Node head2) {
		int l1= 0;
		int l2= 0;
		Node curr1= head1;
		Node sumHead= null;
		while(curr1!= null) {
			l1++;
			curr1= curr1.next;
		}
		Node curr2= head2;
		while(curr2!= null) {
			l2++;
			curr2= curr2.next;
		}
		
		if(l1>=l2) {
			int diff= l1-l2;
			int count= 0;
			curr1= head1;
			Node tail= head1;
			while(count!= diff) {
				count++;
				tail= curr1;
				curr1= curr1.next;
			}
			tail.next= null;
			Node tmpCurr1= curr1;
			int carry= addUtil(tmpCurr1, head2);
			if(carry>0) {
				int c= addCarryUtil(head1, carry);
				tail.next= curr1;
				if(c>0) {
					sumHead= new Node(c);
					sumHead.next= head1;
				} else {
					sumHead= head1;
				}
				
			} else {
				tail.next= curr1;
				sumHead= head1;
			}
			
		} else {
			int diff= l2-l1;
			int count= 0;
			curr1= head2;
			Node tail= head2;
			while(count!= diff) {
				count++;
				tail= curr1;
				curr1= curr1.next;
			}
			tail.next= null;
			Node tmpCurr1= curr1;
			int carry= addUtil(tmpCurr1, head1);
			if(carry>0) {
				int c= addCarryUtil(head2, carry);
				tail.next= curr1;
				if(c>0) {
					sumHead= new Node(c);
					sumHead.next= head2;			
				} else {
					sumHead= head2;
				}
			} else {
				tail.next= curr1;
				sumHead= head2;
			}
		}
		return sumHead;
	}

	private static int addCarryUtil(Node head1, int carry) {
		if(head1== null) {
			return carry;
		}
		int c= addCarryUtil(head1.next, carry);
		int sum= head1.data+c;
		head1.data= sum%10;
		
		return sum/10;
	}

	private static int addUtil(Node head1, Node head2) {
		if(head1== null || head2== null) {
			return 0;
		}
		int carry= addUtil(head1.next, head2.next);
		int sum= head1.data+head2.data+carry;
		head1.data= sum%10;
		
		return sum/10;
	}

}

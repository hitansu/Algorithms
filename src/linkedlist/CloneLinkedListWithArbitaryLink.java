
package linkedlist;

public class CloneLinkedListWithArbitaryLink {

	public static void main(String[] args) {
		Node head= new Node(20);
		head.next= new Node(10);
		head.next.next= new Node(2);
		head.next.next.next= new Node(8);
		head.next.next.next.next= new Node(16);
		head.arb= head.next.next;
		head.next.arb= head.next.next.next;
		head.next.next.arb= head.next.next.next.next;
		head.next.next.next.arb= head;
		head.next.next.next.next.arb= head.next;
		
		print(head);
		Node cloneHead= cloneLinkedList(head);
		System.out.println("print after cloning");
		print(cloneHead);
	}
	
	private static void print(Node head) {
		Node curr= head;
		while(curr!= null) {
			System.out.println("Node: "+curr.data+" Arb: "+curr.arb.data);
			curr= curr.next;
		}
	}

	private static Node cloneLinkedList(Node head) {
		//set the next pointer
		Node curr= head;
		while(curr!= null) {
			Node tmpNext= curr.next;
			curr.next= new Node(curr.data);
			curr.next.next= tmpNext;
			curr= tmpNext;
			
		}
		
		//set the arbitary node
		curr= head;
		while(curr!= null) {
			Node copyNode= curr.next;
			copyNode.arb= curr.arb.next;
			curr= copyNode.next;
		}
		
		//separate both the lists
		curr= head;
		Node newHead= null;
		while(curr!= null) {
			Node orig= curr;
			Node copy= orig.next;
			if(copy== null)
				break;
			if(newHead== null)
				newHead= copy;
			orig.next= copy.next;
			curr= copy;
		}
		return newHead;
	}
	
	
}

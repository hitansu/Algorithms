package linkedlist;

public class Merge2LinkedListWithoutChangingLink {

	public static void main(String[] args) {

		Node h1= new Node(2);
		h1.next= new Node(4);
		h1.next.next= new Node(7);
		h1.next.next.next= new Node(8);
		h1.next.next.next.next= new Node(10);
		
		Node h2= new Node(1);
		h2.next= new Node(3);
		h2.next.next= new Node(12);
		
		merge(h1, h2);
		
		Node curr1= h1;
		Node curr2= h2;
		while(curr1!= null) {
			System.out.print(curr1.data+" ");
			curr1= curr1.next;
		}
		
		while(curr2!= null) {
			System.out.print(curr2.data+" ");
			curr2= curr2.next;
		}
		
		
	}
	
	private static void merge(Node h1, Node h2) {
		
		if(h2!= null && h2.next!= null && h2.data>h2.next.data) {
			int tmp= h2.data;
			h2.data= h2.next.data;
			h2.next.data= tmp;
		}
		
		if(h1== null || h2== null) return;
		
		if(h1.data>h2.data) {
			int tmp= h1.data;
			h1.data= h2.data;
			h2.data= tmp;
		}
		
		merge(h1.next, h2);
	}

}

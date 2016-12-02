package tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorWithoutRoot {

	public static void main(String[] args) {
		Node a=new Node(5);
		Node b=new Node(6);
		Node c=new Node(7);
		Node d=new Node(8);
		Node e=new Node(9);
		a.left=b;
		b.parent=a;
		b.left=c;
		c.parent=b;
		b.right=d;
		d.parent=b;
		d.right=e;
		e.parent=d;
		
		Node lca = findLCAWithoutRoot(c, e);
		System.out.println(lca.data);

	}
	
	static Node findLCAWithoutRoot(Node a, Node b) {
		Set<Node> set= new HashSet<>();
		while(a!= null) {
			set.add(a);
			a= a.parent;
		}
		while(b!= null) {
			if(!set.add(b)) {
				return b;
			}
			b= b.parent;
		}
		return null;
	}
	
	static class Node {
		Node left;
		Node right;
		Node parent;
		int data;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

package disjointSet;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

	Map<Integer, Node> map= new HashMap<>();
	
	static class Node {
		public int data= Integer.MIN_VALUE;
		public int rank= Integer.MIN_VALUE;
		public Node parent= null;
	}
	
	public static void main(String[] args) {
		DisjointSet ds= new DisjointSet();
		
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1).data);
        System.out.println(ds.findSet(2).data);
        System.out.println(ds.findSet(3).data);
        System.out.println(ds.findSet(4).data);
        System.out.println(ds.findSet(5).data);
        System.out.println(ds.findSet(6).data);
        System.out.println(ds.findSet(7).data);
    
	}

	private void union(int i, int j) {
		
		Node n1= findSet(i);
		Node n2= findSet(j);
		
		if(n1.data== n2.data) {
			return;
		}
		
		if(n1.rank>= n2.rank) {
			n2.parent= n1;
			n1.rank= n1.rank== n2.rank ? n1.rank+1 : n1.rank;
		} else {
			n1.parent= n2;
		}
	}

	private Node findSet(int i) {
		Node node = map.get(i);
		if(node.parent.data== i) {
			return node;
		}
		node.parent= findSet(node.parent.data);
		
		return node.parent;
	}

	private void makeSet(int i) {
		Node node= new Node();
		node.data= i;
		node.rank= 0;
		node.parent= node;
		
		map.put(i, node);
	}
}

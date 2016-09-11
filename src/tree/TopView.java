package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopView {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		
		Node root1= new Node(1);
		root1.left= new Node(2);
		root1.right= new Node(3);
		root1.left.right= new Node(4);
		root1.left.right.right= new Node(5);
		root1.left.right.right.right= new Node(6);
		
		Map<Integer, Integer> map= new TreeMap<>();
		getTopView(root, map);
		Set<Integer> keySet = map.keySet();
		for(Integer key: keySet) {
			System.out.print(map.get(key)+" ");
		}
		
		System.out.println("");
		map= new TreeMap<>();
		getTopView(root1, map);
		keySet = map.keySet();
		for(Integer key: keySet) {
			System.out.print(map.get(key)+" ");
		}

	}
	
	private static void getTopView(Node root, Map<Integer, Integer> map) {
		if(root== null) return;
		Queue<Node> q= new LinkedList<>();
		root.level= 0;
		q.add(root);
		while(!q.isEmpty()) {
			Node curr= q.poll();
			if(map.get(curr.level)== null)
				map.put(curr.level, curr.data);
			if(curr.left!= null) {
				curr.left.level= curr.level-1;
				q.add(curr.left);
			}
			if(curr.right!= null) {
				curr.right.level= curr.level+1;
				q.add(curr.right);
			}
		}
	}
	
	static class Node {
		int data;
		Node left, right;
		int level;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

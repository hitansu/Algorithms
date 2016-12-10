package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomView {

	public static void main(String[] args) {
		Node root= new Node(20);
		root.left= new Node(8);
		root.right= new Node(22);
		root.right.left= new Node(4);
		root.right.right= new Node(25);
		root.left.left= new Node(5);
		root.left.right= new Node(3);
		root.left.right.left= new Node(10);
		root.left.right.right= new Node(14);
		
		Map<Integer, Integer> map= new TreeMap<>();
		getBottomView(root, map);
		
		Set<Integer> keySet = map.keySet();
		for(Integer key: keySet) {
			System.out.print(map.get(key)+" ");
		}

	}

	private static void getBottomView(Node root, Map<Integer, Integer> map) {
		if(root== null) return;
		Queue<Node> q= new LinkedList<>();
		root.level= 0;
		q.add(root);
		while(!q.isEmpty()) {
			Node curr= q.poll();
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

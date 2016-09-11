package tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CalculateVerticalSum {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.right.left= new Node(4);
		root.right.left.left= new Node(12);
		root.right.left.right= new Node(7);
		root.right.right= new Node(5);
		root.left.left= new Node(9);
		root.left.left.right= new Node(10);
		root.left.right= new Node(6);
		root.left.right.left= new Node(11);	
		
		Map<Integer, Integer> map= new LinkedHashMap<Integer, Integer>();
		calculateVerticalSum(root, 0, map);
		Set<Integer> keySet = map.keySet();
		for(Integer key: keySet) {
			System.out.println("key- sum "+key+" - "+map.get(key));
		}
		
		System.out.println("Iterative Solution-----------------");
		
		map= calculateVerticalSumIterative(root);
		keySet = map.keySet();
		for(Integer key: keySet) {
			System.out.println("key- sum "+key+" - "+map.get(key));
		}
		
		
		
	}
	
	static Map<Integer, Integer> calculateVerticalSumIterative(CalculateVerticalSum.Node root) {
		Map<Integer, Integer> map= new LinkedHashMap<Integer, Integer>();
		Queue<CalculateVerticalSum.Node> q= new LinkedList<CalculateVerticalSum.Node>();
		q.add(root);
		while(!q.isEmpty()) {
			CalculateVerticalSum.Node curr= q.poll();
			int level= curr.level;
			while(curr!= null) {
				int prevSum= map.get(level)== null?0:map.get(level);
				map.put(level, prevSum+curr.data);
				if(curr.left!= null) {
					curr.left.level= level+1;
					q.add(curr.left);
				}
				curr= curr.right;
			}
		}
		
		return map;
	}
	
	static void calculateVerticalSum(Node root, int level, Map<Integer, Integer> map) {
		if(root== null) return ;
		int prevSum= map.get(level)== null?0:map.get(level);
		map.put(level, prevSum+root.data);
		calculateVerticalSum(root.right, level, map);
		calculateVerticalSum(root.left, level+1, map);		
	}
	
	static class Node{
		int data;
		int level;
		Node left,right;
		
		public Node(int data) {
			this.data= data;
			this.level= 0;
		}
		
	}

}

package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PrintNodesBetweenLevels {

	static Map<Integer, List<Node>> map= new HashMap<>();
	public static void main(String[] args) {
		Node root= new Node(20);
		root.left= new Node(8);
		root.right= new Node(22);
		root.left.left= new Node(4);
		root.left.right= new Node(12);
		root.left.right.left= new Node(10);
		root.left.right.right= new Node(14);
		root.right= new Node(22);
		
		int strtLevel= 2;
		int endLevel= 4;
		printNodeBetweenLevels(root, strtLevel, endLevel);
		System.out.println("\n"+"******Recursion******");
		printUsingRecursion(root, 1);
		for(int i= strtLevel;i<= endLevel;i++) {
			List<Node> list = map.get(i);
			for(int index= 0;index< list.size();index++) {
				System.out.print(list.get(index).data+" ");
			}
			System.out.println("");
		}
	}

	private static void printNodeBetweenLevels(Node root, int strtLevel, int endLevel) {
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);
		q.add(null);
		int level= 1;
		while(!q.isEmpty()) {
			Node node= q.poll();
			if(node== null) {
				if(q.peek()== null) return;
				if(level!= 0) {
					System.out.println("");
				}
				++level;
				q.add(null);
			} else {
				if(level>= strtLevel && level<= endLevel) {
					System.out.print(node.data+" ");
				}
				if(node.left!= null) q.add(node.left);
				if(node.right!= null) q.add(node.right);
			}
		}
	}
	
	private static void printUsingRecursion(Node root, int level) {
		if(root== null) return;
		if(map.get(level)!= null) {
			List<Node> l= map.get(level);
			l.add(root);
			map.put(level, l);
		} else {
			List<Node> l= new ArrayList<>();
			l.add(root);
			map.put(level, l);
		}
		printUsingRecursion(root.left, level+1);
		printUsingRecursion(root.right, level+1);
	}

}

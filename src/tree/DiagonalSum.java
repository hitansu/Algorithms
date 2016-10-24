package tree;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 
 * @author hitansu
 *
 */
public class DiagonalSum {

	public static void main(String[] args) {
		    Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(9);
	        root.left.right = new Node(6);
	        root.right.left = new Node(4);
	        root.right.right = new Node(5);
	        root.right.left.left = new Node(12);
	        root.right.left.right = new Node(7);
	        root.left.right.left = new Node(11);
	        root.left.left.right = new Node(10);
	        
	        LinkedHashMap<Integer, Integer> map= new LinkedHashMap<>();
	        getDiagonalSum(root, 0, map);
	        Set<Integer> keySet = map.keySet();
	        for(Integer key: keySet) {
	        	System.out.println("Sum- "+map.get(key));
	        }

	}

	private static void getDiagonalSum(Node root, int level, LinkedHashMap<Integer, Integer> map) {
		if(root== null)
			return;
		Integer sum = map.get(level);
		if(sum== null || sum== 0) {
			sum= 0;
		}
		map.put(level, sum+root.data);
		getDiagonalSum(root.right, level, map);
		getDiagonalSum(root.left, level+1, map);
		
	}

}

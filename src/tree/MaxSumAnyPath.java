package tree;

import java.util.ArrayList;
import java.util.List;

public class MaxSumAnyPath {

	public static void main(String[] args) {
		Node root= new Node(10);
		root.left= new Node(5);
		root.right= new Node(-3);
		root.right.right= new Node(11);
		root.left.left= new Node(3);
		root.left.right= new Node(2);
		root.left.right.right= new Node(1);
		root.left.left.left= new Node(3);
		root.left.left.left.right= new Node(-2);
		
		int path_count = printAnyPathForASum(root, 8, 8, new ArrayList<Node>());
		System.out.println(path_count);

	}
	
	static int printAnyPathForASum(Node root, int target, int sum, List<Node> path) {
		if(sum== 0) {
			printPath(path);
			return 1;
		}
		if(root== null) return 0;
		if(root.data== sum) {
			path.add(root);
			printPath(path);
			path.remove(root);
			return 1;
		}
		
		path.add(root);
		int pathcount= 0;
		pathcount+= printAnyPathForASum(root.left, target, sum-root.data, path);
		pathcount+= printAnyPathForASum(root.right, target, sum - root.data, path);
		path.remove(root);
		pathcount+= printAnyPathForASum(root.left, target, sum, path);
		pathcount+= printAnyPathForASum(root.right, target, sum, path);
		
		return pathcount;
	}

	private static void printPath(List<Node> path) {
		for(Node node: path) {
			System.out.print(node.data+" ");
		}
		System.out.println("");
	}

}

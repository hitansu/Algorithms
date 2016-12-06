package tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathFromRootToLeafForSum {

	public static void main(String[] args) {

		Node root= new Node(10);
		root.left= new Node(1);
		root.right= new Node(1);
		root.left.left= new Node(2);
		root.right.right= new Node(2);
		root.right.right.right= new Node(3);
		root.right.right.right.right= new Node(5);
		root.left.left.left= new Node(3);
		root.left.left.left.left= new Node(5);
		root.right.right.left= new Node(2);
		root.right.right.left.left= new Node(7);
		root.left.left.right= new Node(4);
		root.left.left.right.right= new Node(5);
		
		List<Node> path= new ArrayList<>();
		printSumPath(root, 21, path);
		
	}
	
	private static void printSumPath(Node root, int sum, List<Node> path) {
		if(root== null)
			return;
		if(root.left== null && root.right== null && sum== root.data) {
			path.add(root);
			printPath(path);
			path.remove(root);
		}
		path.add(root);
		printSumPath(root.left, sum-root.data, path);
		printSumPath(root.right, sum-root.data, path);
		path.remove(root);
	}

	private static void printPath(List<Node> path) {

		for(Node node: path) {
			System.out.print(node.data+" ");
		}
		System.out.println("");
	}

}

package tree;

import java.util.ArrayList;
import java.util.List;

public class FindPathFromRootToLeafForASum {

	public static void main(String[] args) {
		Node root= new Node(10);
		root.left= new Node(8);
		root.right= new Node(2);
		root.left.left= new Node(3);
		root.left.right= new Node(5);
		root.right.left= new Node(2);
		
		List<Node> path = findPathForSum(root, 23);
		String s= "";
		for(Node node: path) {
			s= node.data+" "+s;
		}
		System.out.println(s);
	}

	private static List<Node> findPathForSum(Node root, int sum) {
		List<Node> path= new ArrayList<>();
		if(root== null) return path;
		if(root.left== null && root.right== null && root.data== sum) {
			path.add(root);
			return path;
		}
		path= findPathForSum(root.left, sum-root.data);
		if(path.isEmpty()) {
			path= findPathForSum(root.right, sum-root.data);
		}
		if(!path.isEmpty()) path.add(root);
		return path;
	}
}

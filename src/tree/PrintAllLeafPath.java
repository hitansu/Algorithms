package tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllLeafPath {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		List<Node> nodes= new ArrayList<>();
		
		printAllLeafPathFromRoot(root, nodes);
		
	}
	
	private static void printAllLeafPathFromRoot(Node root, List<Node> nodes) {
		if(root== null) return;
		nodes.add(root);
		if(root.left== null && root.right== null) {
			printPath(nodes);
			return;
		}
		printAllLeafPathFromRoot(root.left, nodes);
		if(root.left!= null)
			nodes.remove(root.left);
		printAllLeafPathFromRoot(root.right, nodes);
		if(root.right!= null)
			nodes.remove(root.right);	
	}

	private static void printPath(List<Node> nodes) {
		for(Node node: nodes) {
			System.out.print(node.data+" ");
		}
		System.out.println("");
	}

}

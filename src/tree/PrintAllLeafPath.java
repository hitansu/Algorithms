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
		System.out.println("\n*******");
		printRootToLeaf(root, 0, new ArrayList<Node>());
		System.out.println("\n*******");
		printAllLeafPathFromRoot_(root, new ArrayList<Node>());
		
	}
	
	private static void printAllLeafPathFromRoot_(Node root, List<Node> nodes) {
		if(root== null) return;
		if(root.left== null && root.right== null) {
			nodes.add(root);
			printPath(nodes);
			nodes.remove(root);
			return;
		}
		nodes.add(root);
		printAllLeafPathFromRoot_(root.left, nodes);
		printAllLeafPathFromRoot_(root.right, nodes);
		nodes.remove(root);
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
	
	private static void printRootToLeaf(Node root, int index, List<Node> nodes) {
		if(root== null)
			return;
		if(root.left== null && root.right== null) {
			if(index>= nodes.size()) {
				nodes.add(root);
			} else {
				nodes.set(index, root);
			}
			printPath(nodes, index);
			return;
		}
		if(index>= nodes.size()) {
			nodes.add(root);
		} else {
			nodes.set(index, root);
		}
		printRootToLeaf(root.left, index+1, nodes);
		printRootToLeaf(root.right, index+1, nodes);
	}

	private static void printPath(List<Node> nodes, int index) {
		int count= 0;
		for(Node node: nodes) {
			System.out.print(node.data+" ");
			count++;
			if(count== index+1)
				break;
		}
		System.out.println("");
	}

	private static void printPath(List<Node> nodes) {
		for(Node node: nodes) {
			System.out.print(node.data+" ");
		}
		System.out.println("");
	}

}

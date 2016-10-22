package dp;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossibleTrees {

	public static void main(String[] args) {
		int in[] = {4, 5, 7};
		List<Node> trees = getTrees(in, 0, in.length-1);
		System.out.println(trees.size());
		for(Node root: trees) {
			traverse(root);
			System.out.println("");
		}
	}
	
	static void traverse(Node root) {
		if(root== null) return;
		System.out.print(root.data+" ");
		traverse(root.left);
		traverse(root.right);
	}
	
	static List<Node> getTrees(int[] arr,int l,int h) {
		List<Node> trees= new ArrayList<>();
		if(l>h) {
			trees.add(null);
			return trees;
		}
		if(l== h) {
			Node root= new Node(arr[l]);
			trees.add(root);
			return trees;
		}
		for(int i= l;i<=h;i++) {
			List<Node> leftTrees= getTrees(arr, l, i-1);
			List<Node> rightTrees= getTrees(arr, i+1, h);
			
			for(Node left: leftTrees) {
				for(Node right: rightTrees) {
					Node root= new Node(arr[i]);
					root.left= left;
					root.right= right;
					trees.add(root);
				}
			}
		}
		return trees;
	}
	
	static class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data= data;
		}
	}

}

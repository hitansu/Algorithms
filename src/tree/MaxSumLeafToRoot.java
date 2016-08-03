package tree;

import java.util.ArrayList;
import java.util.List;

public class MaxSumLeafToRoot {

	public static void main(String[] args) {
		Node root= new Node(10);
		root.left= new Node(-2);
		root.right= new Node(7);
		root.right.left= new Node(9);
		root.right.left.right= new Node(-12);
		root.right.left.left= new Node(5);
		root.right.left.left.left= new Node(10);
		root.right.left.left.right= new Node(3);
		root.right.left.left.left.left= new Node(6);
		root.right.right= new Node(8);
		root.left.left= new Node(8);
		root.left.right= new Node(-4);
		List<Node> path= new ArrayList<>();
		System.out.println(findMaxSum(root, path));
		for(Node node: path) {
			System.out.print(node.data+" ");
		}
	}
	
	private static int findMaxSum(Node root, List<Node> path) {
		return maxSumUtil(root, 0, path);
	}
	
	private static int maxOnlySumUtil(Node root, int sum) {
		if(root== null) return 0;
		if(root.left== null && root.right== null) {
			return sum+root.data;
		}
		int max= Integer.MIN_VALUE;
		int sumL= maxOnlySumUtil(root.left, sum+root.data);
		int sumR= maxOnlySumUtil(root.right, sum+root.data);
		if(sumL>max) {
			max= sumL;
		}
		if(sumR>max) {
			max= sumR;
		}
		
		return max;
	}

	private static int maxSumUtil(Node root, int sum, List<Node> path) {
		if(root== null) return 0;
		if(root.left== null && root.right== null) {
			path.add(root);
			return sum+root.data;
		}
		int max= Integer.MIN_VALUE;
		path.add(root);
		int index= path.size()-1;
		int sumL= maxSumUtil(root.left, sum+root.data, path);
		List<Node> exPath= removePath(path, index);
		int sumR= maxSumUtil(root.right, sum+root.data, path);
		int localMax= 0;
		if(sumL>sumR) {
			localMax= sumL;
			path= addPath(path, index, exPath);
		} else {
			localMax= sumR;
		}
		if(localMax<max) {
			path= remove(path, index);
		}else {
			max= localMax;
		}
		
/*		if(max<sumL) max= sumL;
		else remove(path, index);
		int sumR= maxSumUtil(root.right, sum+root.data, path);
		if(max<sumR) max= sumR;*/
		
		return max;
	}

	private static List<Node> addPath(List<Node> path, int index, List<Node> exPath) {
		removePath(path, index);
		for(Node node: exPath) {
			path.add(node);
		}
		return path;
	}

	private static List<Node> removePath(List<Node> path, int index) {
		int size= path.size();
		if(index== size-1) return path;
		List<Node> exPath= new ArrayList<>();
		for(int i= size-1;i>= index+1;i--) {
			exPath.add(path.remove(i));
		}
		return exPath;
	}

	private static List<Node> remove(List<Node> path, int index) {
		int size= path.size();
		if(index== size-1) return path;
		for(int i= index+1;i<size;i++) {
			path.remove(i);
		}
		return path;
		
	}

}

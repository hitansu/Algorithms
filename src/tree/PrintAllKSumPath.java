package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllKSumPath {

	public static void main(String[] args) {
		int k= 5;
		List<Node> path= new ArrayList<>();
	/*	Node root1= new Node(1);
		Node root= new Node(-1);
		
		root.left= new Node(4);
		root.right= new Node(5);
		root.right.right= new Node(6);
		root.left.left= new Node(1);
		root.left.right= new Node(2);
		
		root1.right= root;*/
		Node root= new Node(1);
		root.left= new Node(3);
		root.right= new Node(-1);
		root.right.right= new Node(5);
		root.right.right.right= new Node(6);
		root.right.left= new Node(4);
		root.right.left.left= new Node(1);
		root.right.left.right= new Node(2);
		root.left.left= new Node(2);
		root.left.right= new Node(1);
		root.left.right.left= new Node(1);
       
	//	printPath(root1, k, k, path);
		findSum(root, k, new ArrayList<Integer>(), 0);
	}
	
	static void findSum(Node head, int sum, ArrayList<Integer> buffer, int level) {
		 if (head == null) return;
		 int tmp = sum;
		 buffer.add(head.data);
		 for (int i = level;i >- 1; i--) {
			 tmp -= buffer.get(i);
			 if (tmp == 0) 
				 print(buffer, i, level);
		 }
		 ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		 ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		 findSum(head.left, sum, c1, level + 1);
		 findSum(head.right, sum, c2, level + 1);
	}
			
	static void print(ArrayList<Integer> buffer, int level, int i2) {
		 for (int i = level; i <= i2; i++) {
			  System.out.print(buffer.get(i) +" ");
		 }
		 System.out.println();
	}
	
	private static void printPath(Node root, int sum, int k, List<Node> path) {
		if(root== null) {
			return;
		}
		path.add(root);
		sum= sum-root.data;
		if(sum== 0) {
			printlist(path);
		}
		printPath(root.left, sum, k, path);
		printPath(root.right, sum, k, path);
		path.remove(root);
		List<Node> tmp1= new ArrayList<>();
		List<Node> tmp2= new ArrayList<>();
		printPath(root.left, k, k, tmp1);
		printPath(root.right, k, k, tmp2);
		
	}

	private static void printlist(List<Node> path) {
		System.out.print("Path:  ");
		for(Node node: path) {
			System.out.print(node.data+" ");
		}
		System.out.println("");
	}

}

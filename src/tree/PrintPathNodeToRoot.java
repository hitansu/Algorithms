package tree;

import java.util.ArrayList;
import java.util.List;

public class PrintPathNodeToRoot {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(5);
		root.left.left.left= new Node(9);
		root.left.left.right= new Node(8);
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		
		System.out.println(printPathNodeToRoot(root, 8));
		System.out.println(printPathNodeToRoot(root, 7));
		System.out.println(printPathNodeToRoot(root, 9));
		System.out.println(printPathNodeToRoot(root, 4));
		
		System.out.println("*********************");
		printPathNodeToRootBool(root, 8);
		System.out.println("");
		printPathNodeToRootBool(root, 7);
		
		System.out.println("\n"+"*********************");
		List<Node> paths = returnPathToRoot(root, 8);
		int size= paths.size();
		for(int i= size-1;i>=0;i--) {
			System.out.print(paths.get(i).data+" ");
		}
	}
	
	private static String printPathNodeToRoot(Node root, int data) {
		if(root== null) return "";
		if(root.data== data) return ""+root.data;
		String path= printPathNodeToRoot(root.left, data);
		if(path.isEmpty()) {
			path= printPathNodeToRoot(root.right, data);
		}
		if(!path.isEmpty()) {
			path= root.data+" "+path;
		}
		return path;
	}
	
	private static List<Node> returnPathToRoot(Node root, int data) {
		List<Node> paths= new ArrayList<>();
		if(root== null) return paths;
		if(root.data== data) {
			paths.add(root);
			return paths;
		}
		
		paths= returnPathToRoot(root.left, data);
		if(paths.isEmpty()) {
			paths= returnPathToRoot(root.right, data);
		}
		
		if(!paths.isEmpty()) {
			paths.add(root);
		}
		return paths;
	}
	
	private static boolean printPathNodeToRootBool(Node root, int data) {
		if(root== null) return false;
		if(root.data== data) {
			System.out.print(" "+root.data);
			return true;
		}
		boolean isFound= printPathNodeToRootBool(root.left, data);
		if(!isFound) {
			isFound= printPathNodeToRootBool(root.right, data);
		}
		
		if(isFound) {
			System.out.print(" "+root.data);
		}
		return isFound;
	}

}

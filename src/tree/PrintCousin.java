package tree;

public class PrintCousin {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		
		Result r= new Result();
		printCousin(root, null, 5, 0, r);

	}
	
	static class Result {
		int level;
		Node parent;
	}

	private static void printCousin(Node root, Node parent, int data, int level, Result r) {
		if(root== null)
			return;
		if(root.data== data) {
			r.level= level;
			r.parent= parent;
			return;
		}
		if(level== r.level && r.parent!= parent) {
			System.out.print(root.data+" ");
		}
		
		printCousin(root.left, root, data, level+1, r);
		printCousin(root.right, root, data, level+1, r);
		
	}

}

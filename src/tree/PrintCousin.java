package tree;

/**
 *         1
 *     2       3
 *  4    5   6    7
 *  
 *  Cousin of 4 will be 6, 7 (node with same level but diff parent)
 *  Cousin of 5 will be 6, 7 (node with same level but diff parent)
 *  Cousin of 6 will be 4, 5 (node with same level but diff parent)
 *  Cousin of 7 will be 4, 5 (node with same level but diff parent)
 * 
 * @author jenah
 *
 */
public class PrintCousin {

	public static void main(String[] args) {
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		
		printCousin(root, 6);

	}
	
	static class Result {
		int level;
		Node parent;
	}

	private static void printCousin(Node root, int data) {
		
		Result r= new Result();
		getLevel(root, null, data, 0, r);
		printCousinUtil(root, null, 0, r);
		
	}

	private static void printCousinUtil(Node root, Node parent, int level, Result r) {
		if(root== null)
			return;
		if(level== r.level && r.parent!= parent) {
			System.out.print(root.data+" ");
		}
		
		printCousinUtil(root.left, root, level+1, r);
		printCousinUtil(root.right, root, level+1, r);
	}

	private static void getLevel(Node root, Node parent, int data, int level, Result r) {
		if(root== null) return;
		if(root.data== data) {
			r.level= level;
			r.parent= parent;
		}
		
		getLevel(root.left, root, data, level+1, r);
		getLevel(root.right, root, data, level+1, r);
	}

}

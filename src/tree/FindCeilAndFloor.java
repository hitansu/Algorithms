package tree;

public class FindCeilAndFloor {

	public static void main(String[] args) {
		Node root= new Node(10);
		root.left= new Node(4);
		root.left.left= new Node(2);
		root.left.right= new Node(8);
		root.right= new Node(15);
		root.right.right= new Node(20);
		root.right.left= new Node(12);
		
		Node floor= findFloor(root, 9);
		System.out.println("Floor:: "+floor.data);
	
		Node ceil= findCeil(root, 13);
		System.out.println("Ceil:: "+ceil.data);

	}
	
	static Node prevFloor= null;
	private static Node findFloor(Node root, int data) {
		if(root== null) return root;
		Node lFloor= findFloor(root.left, data);
		if(lFloor!= null) return lFloor;
		if(root.data== data) return root;
		if(root.data>data) return prevFloor;
		prevFloor= root;
		return findFloor(root.right, data);
	}
	
	static Node prevCeil= null;
	private static Node findCeil(Node root, int data) {
		if(root== null) return root;
		Node rCeil= findCeil(root.right, data);
		if(rCeil!= null) return rCeil;
		if(root.data== data) return root;
		if(root.data<data) return prevCeil;
		prevCeil= root;
		return findCeil(root.left, data);
	}

}

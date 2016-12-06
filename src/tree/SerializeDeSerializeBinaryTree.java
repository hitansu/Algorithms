package tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeSerializeBinaryTree {

	public static void main(String[] args) {
		Node root= new Node(20);
		root.left= new Node(8);
		root.right= new Node(10);
		root.right.left= new Node(14);
		root.right.right= new Node(15);
		root.left.left= new Node(4);
		root.left.right= new Node(12);
		root.left.right.left= new Node(10);
		root.left.right.right= new Node(14);
		
		traverse(root);
		
		List<Integer> serialized= new ArrayList<>();
		serialize(root, serialized);
		System.out.println("");
		Node root2= deserialize(serialized);
		traverse(root2);
	}
	
	private static void traverse(Node root) {
		if(root== null) return;
		System.out.print(root.data+" ");
		traverse(root.left);
		traverse(root.right);
	}
	
	private static void serialize(Node root, List<Integer> serialized) {
		if(root== null) {
			serialized.add(-1);
			return;
		}
		serialized.add(root.data);
		serialize(root.left, serialized);
		serialize(root.right, serialized);
	}
	
	static int index= 0;
	private static Node deserialize(List<Integer> serializednodes) {
		if(index>= serializednodes.size() || serializednodes.get(index)== -1) {
			index++;
			return null;
		}
		Node root= new Node(serializednodes.get(index));
		index++;
		root.left= deserialize(serializednodes);
		root.right= deserialize(serializednodes);
		return root;
	}

}

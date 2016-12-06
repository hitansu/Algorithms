package tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeSerializeBST {

	public static void main(String[] args) {
		
		Node root= new Node(20);
		root.left= new Node(15);
		root.right= new Node(30);
		root.left.left= new Node(10);
		root.left.right= new Node(18);
		root.right.left= new Node(25);
		
		traverse(root);
		
		System.out.println("");
		
		List<Integer> serialized= new ArrayList<>();
		serialize(root, serialized);
		Node root2= deserialize(serialized, 0, serialized.size()-1);
		traverse(root2);
	}
	
	private static void traverse(Node root) {
		if(root== null) return;
		System.out.print(root.data+" ");
		traverse(root.left);
		traverse(root.right);
	}

	private static Node deserialize(List<Integer> serialized, int low, int high) {
		if(low> high) return null;
		if(low== high) return new Node(serialized.get(low));
		
		Node root= new Node(serialized.get(low));
		int index= getRightTreeIndex(serialized, root.data, low+1, high);
		root.left= deserialize(serialized, low+1, index-1);
		root.right= deserialize(serialized, index, high);
		return root;
	}

	private static int getRightTreeIndex(List<Integer> serialized, int data, int low, int high) {
		
		if(low>high) return -1;
		if(low== high) return low;
		int i;
		for(i= low;i<=high;i++) {
			if(data<serialized.get(i)) {
				break;
			}
		}
		return i;
	}

	private static void serialize(Node root, List<Integer> serialized) {
		if(root== null) {
			return;
		}
		serialized.add(root.data);
		serialize(root.left, serialized);
		serialize(root.right, serialized);
		
	}

}

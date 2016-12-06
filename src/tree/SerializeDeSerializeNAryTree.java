package tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeSerializeNAryTree {

	public static void main(String[] args) {
		NAryNode root= new NAryNode(10);
		root.childs.add(new NAryNode(2));
		root.childs.add(new NAryNode(34));
		root.childs.add(new NAryNode(56));
		root.childs.add(new NAryNode(100));
		root.childs.get(2).childs.add(new NAryNode(1));
		root.childs.get(3).childs.add(new NAryNode(7));
		root.childs.get(3).childs.add(new NAryNode(8));
		root.childs.get(3).childs.add(new NAryNode(9));
		traverse(root);
		
		List<Integer> serialized= new ArrayList<>();
		serilaize(root, serialized);
		System.out.println("\n"+serialized);
		NAryNode root2= deserialize(serialized);
		traverse(root2);
	}
	
	private static void traverse(NAryNode root) {
		if(root== null) return;
		System.out.print(root.data+" ");
		List<NAryNode> children = root.childs;
		for(NAryNode chid: children) {
			traverse(chid);
		}
	}

	static int index= 0;
	static int N= 4;
	private static NAryNode deserialize(List<Integer> serialized) {
		if(index>= serialized.size() || serialized.get(index)== -1) {
			index++;
			return null;
		}
		NAryNode root= new NAryNode(serialized.get(index));
		index++;
		root.childs= new ArrayList<>();
		for(int i= 0;i<N;i++) {
			NAryNode child= deserialize(serialized);
			if(child== null) {
				break;
			}
			root.childs.add(child);
		}
		return root;
	}

	private static void serilaize(NAryNode root, List<Integer> serialized) {
		if(root== null) return;
		serialized.add(root.data);
		List<NAryNode> childs = root.childs;
		for(NAryNode child: childs) {
			serilaize(child, serialized);
		}
		serialized.add(-1);
		
	}

}

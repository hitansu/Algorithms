package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MirrorOfNAryTree {

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
		
		printTreeLevelOrder(root);
		mirrorOfTree(root);
		System.out.println("\nAfter mirroring.....");
		printTreeLevelOrder(root);
	}

	private static void printTreeLevelOrder(NAryNode root) {
		Queue<NAryNode> q= new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			NAryNode node = q.poll();
			System.out.print(node.data+" ");
			for(NAryNode child: node.childs) {
				q.add(child);
			}
		}
		
	}

	private static void mirrorOfTree(NAryNode root) {
		if(root== null) return;
		for(NAryNode child: root.childs) {
			mirrorOfTree(child);
		}
		Collections.reverse(root.childs);
		
	}

}

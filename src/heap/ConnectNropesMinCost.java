package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectNropesMinCost {

	public static void main(String[] args) {
		int len[] = {4, 3, 2, 6};
		int cost= calculateCost(len);
		System.out.println("Cost is: "+cost);

	}

	static Comparator<Integer> decreaseOrder= new Comparator<Integer>() {
		
		@Override
		public int compare(Integer a, Integer b) {
			if(a>b) {
				return 1;
			} else if(a<b) {
				return -1;
			} else 
				return 0;
		}
	};
	
	private static int calculateCost(int[] len) {
		PriorityQueue<Integer> minHeap= new PriorityQueue<>(len.length, decreaseOrder);
		for(int i= 0;i<len.length;i++) {
			minHeap.offer(len[i]);
		}
		
		int cost= 0;
		while(!minHeap.isEmpty()) {
			int cost1 = minHeap.poll();
			if(minHeap.isEmpty())
				return cost;
			int cost2= minHeap.poll();
			cost+= cost1+cost2;
			minHeap.offer(cost1+cost2);
		}
		return cost;
	}

}

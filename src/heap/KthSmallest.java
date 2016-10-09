package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

	public static void main(String[] args) {
		int k= 3;
		int[] arr= {20,23,12,14,21,25,28,18};
		
		printKthSmallest(arr, k);	

	}
	
	static Comparator<Integer> increaseOrder= new Comparator<Integer>() {
		
		@Override
		public int compare(Integer a, Integer b) {
			if(a>b) {
				return -1;
			} else if(a<b) {
				return 1;
			} else {
				return 0;
			}
		}
	};

	private static void printKthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(k, increaseOrder);
		for(int i= 0;i<k;i++) {
			maxHeap.offer(arr[i]);
		}
		
		for(int i= k;i<arr.length;i++) {
			if(maxHeap.peek()>arr[i]) {
				maxHeap.poll();
				maxHeap.offer(arr[i]);
			}
		}
		
		while(!maxHeap.isEmpty()) {
			System.out.print(maxHeap.poll()+" ");
		}
		
		
		
	}

}

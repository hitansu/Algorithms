package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		int k= 3;
		int[] arr= {20,23,12,14,21,25,28,18};
		
		printKthLargest(arr, k);	

	}
	
	static Comparator<Integer> decreaseOrder= new Comparator<Integer>() {
		
		@Override
		public int compare(Integer a, Integer b) {
			if(a>b) {
				return 1;
			} else if(a<b) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	private static void printKthLargest(int[] arr, int k) {
		PriorityQueue<Integer> minHeap= new PriorityQueue<Integer>(k, decreaseOrder);
		for(int i= 0;i<k;i++) {
			minHeap.offer(arr[i]);
		}
		
		for(int i= k;i<arr.length;i++) {
			if(minHeap.peek()<arr[i]) {
				minHeap.poll();
				minHeap.offer(arr[i]);
			}
		}
		
		while(!minHeap.isEmpty()) {
			System.out.print(minHeap.poll()+" ");
		}
		
		
		
	}

}

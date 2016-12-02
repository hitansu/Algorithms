package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianStreamOfNumber {

	public static void main(String[] args) {
		 
		Integer[] arr= {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		Arrays.sort(arr, increaseOrder);
		for(Integer i: arr) {
			System.out.println(i);
		}
	//	int median= findMedian(arr);
	//	System.out.println("Madian: "+median);

	}
	
	static Comparator<Integer> increaseOrder= new Comparator<Integer>() {
		
		@Override
		public int compare(Integer a, Integer b) {
			if(a>b) {
				return -1;
			} else if(a<b) {
				return 1;
			} else
				return 0;
		}
	};
	
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

	private static int findMedian(int[] arr) {
		PriorityQueue<Integer> maxHeap= new PriorityQueue<>(arr.length, increaseOrder);
		PriorityQueue<Integer> minHeap= new PriorityQueue<>(arr.length, decreaseOrder);
		for(int i= 0;i<arr.length;i++) {
			maxHeap.offer(arr[i]);
			minHeap.offer(maxHeap.poll());
			if(maxHeap.size()<minHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
			
			printMedian(maxHeap, minHeap);
		}
		
		if(maxHeap.size()== minHeap.size()) {
			return (maxHeap.peek()+minHeap.peek())/2;
		} else {
			return maxHeap.peek();
		}
	}

	private static void printMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if(maxHeap.size()== minHeap.size()) {
			System.out.println((maxHeap.peek()+minHeap.peek())/2);
		} else {
			System.out.println(maxHeap.peek());
		}
		
	}

}

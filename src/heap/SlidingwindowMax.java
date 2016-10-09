package heap;

import java.util.LinkedList;

public class SlidingwindowMax {

	public static void main(String[] args) {
		
		int[] arr= {1,3,-1,-3,5,3,6,7};
		int k= 3;
		int[] output= findMax(arr,k);
		
		for(int i= 0;i<output.length;i++) {
			System.out.println(output[i]+" ");
		}

	}

	private static int[] findMax(int[] arr,int k) {
		LinkedList<Integer> dq= new LinkedList<>();
		for(int i= 0;i<k;i++) {
			while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		int[] output= new int[arr.length-k+1];
		for(int i=k;i<arr.length;i++) {
			output[i-k]= arr[dq.peekFirst()];
			/**
			 * remove outbounded element
			 */
			while(!dq.isEmpty() && dq.peekLast()<= i-k) {
				dq.pollFirst();
			}
			/**
			 * remove element which are less than current element
			 */
			while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) {
				dq.pollLast();
			}

			dq.addLast(i);
		}
		output[arr.length-k]= dq.peekFirst();
		return output;
	}

}

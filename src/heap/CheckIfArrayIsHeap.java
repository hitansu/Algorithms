package heap;

public class CheckIfArrayIsHeap {

	public static void main(String[] args) {
		
		int[] arr= {90, 15, 10, 7, 12, 2};
		boolean isHeap= isHeap(arr,0);
		System.out.println("Isheap: "+isHeap);
		int[] arr1= {9, 15, 10, 7, 12, 11};
		isHeap= isHeap(arr1, 0);
		System.out.println("Isheap: "+isHeap);

	}

	private static boolean isHeap(int[] arr,int i) {
		if(i>=(arr.length-1)/2)
			return true;
		
		if(arr[i]>=arr[2*i+1] && arr[i]>=arr[2*i+2] && isHeap(arr, 2*i+1) && isHeap(arr, 2*i+2)) {
			return true;
		} else {
			return false;
		}
	}

}

package array;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr= {5,2,6,3,2,5,6,8,0};
		arr= sort(arr);
		for(Integer i: arr) {
			System.out.print(i+" ");
		}
	}
	
	private static int[] sort(int[] arr) {
		int l= arr.length;
		boolean isSwapped= true;
		for(int i= 0;i<l-1 && isSwapped;i++) {
			for(int j= 0;j<l-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int tmp= arr[j+1];
					arr[j+1]= arr[j];
					arr[j]= tmp;
					isSwapped= true;
				}
			}
		}
		return arr;
	}
}

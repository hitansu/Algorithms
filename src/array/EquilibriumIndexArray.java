package array;

public class EquilibriumIndexArray {

	public static void main(String[] args) {
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		int index= findEquilibriumIndex(arr);
		System.out.println("index: "+index+" element: "+arr[index]);
	}

	private static int findEquilibriumIndex(int[] arr) {
		int l= arr.length;
		int sum= 0;
		for(int i= 0;i<l;i++) {
			sum+= arr[i];
		}
		
		int leftsum= arr[0];
		for(int i= 1;i<l;i++) {
			int rightsum= sum-arr[i]-leftsum;
			if(leftsum== rightsum) {
				return i;
			}
			leftsum+= arr[i];
		}
		return -1;
	}
}

package array;

public class RotateArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		arr= rotateArray(arr, 2);
		for(Integer i: arr) {
			System.out.println(i+" ");
		}
	}
	
	static int[] rotateArray(int[] a, int d) {
		reverseArray(a,0,d-1);
		reverseArray(a, d, a.length-1);
		reverseArray(a, 0, a.length-1);
		
		return a;
	}

	private static void reverseArray(int[] a, int i, int j) {
		while(i<j) {
			int tmp= a[i];
			a[i]= a[j];
			a[j]= tmp;
			i++;
			j--;
		}
		
	}

}

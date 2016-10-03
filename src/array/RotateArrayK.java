package array;

public class RotateArrayK {

	public static void main(String[] args) {
		int[] arr= {1, 2, 3, 4, 5, 6, 7, 8, 9};
		arr= rotateArray(arr, 3);
		int[] arr1= {1, 2, 3, 4, 5, 6, 7, 8};
		for(Integer i: arr) {
			System.out.print(i+" ");
		}

	}
	
	private static int[] rotateArray(int[] a, int k) {
		int j= 0;
		int start= 0;
		int l= 0;
		for(int i= 0;i<a.length;i++) {
			j= i%k;
			if(j== 0) {
				l= k-1;
				start= i;
			}
			if(j<=l) {
				if(start+l<a.length) {
					int tmp= a[i];
					a[i]= a[start+l];
					a[start+l]= tmp;
					l--;
				}
				
			}
		}
		return a;
	}

}

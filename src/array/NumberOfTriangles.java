package array;

import java.util.Arrays;

public class NumberOfTriangles {

	public static void main(String[] args) {
		
		int[] arr= {10, 21, 22, 100, 101, 200, 300};
		int count= countNoOfTriangles(arr);
		System.out.println(count);

	}

	private static int countNoOfTriangles(int[] arr) {
		Arrays.sort(arr);
		int n= arr.length;
		int count= 0;
		for(int i= 0;i<=n-3;i++) {
			int k= i+2;
			for(int j= i+1;j<= n-2;j++) {
				while(k<n && arr[i]+arr[j]>arr[k]) {
					k++;
				}
				count+= k-j-1;
			}
		}
		return count;
	}

}

package array;

public class MaxCircularSum {

	public static void main(String[] args) {

	//	int[] arr= {8, -8, 9, -9, 10, -11, 12};
		int[] arr = {10, -3, -4, 7, 6, 5, -4, -1};
		int sum= findMaxCircularSum(arr);
		System.out.println(sum);
	}

	private static int findMaxCircularSum(int[] a) {
		int n= a.length;
		int sum_1= findSum(a);
		int sum= 0;
		for(int i= 0;i<n;i++) {
			sum+= a[i];
			a[i]= -a[i];
		}
		int sum_2= findSum(a);
		
		return Math.max(sum_1, sum+sum_2);
	}

	private static int findSum(int[] a) {
		int n= a.length;
		int max_sum= Integer.MIN_VALUE;
		int max_so_far= 0;
		for(int i= 0;i<n;i++) {
			max_so_far+= a[i];
			if(max_so_far<0) {
				max_so_far= 0;
			}
			if(max_sum<max_so_far) {
				max_sum= max_so_far;
			}
		}
		return max_sum;
	}

}

package dp;

public class MaxIncreasingSumSubSequence {

	public static void main(String[] args) {
	//	int[] arr= {1, 101, 2, 3, 100, 4, 5};
		int[] arr= {10, 5, 4, 3};
		MaxIncreasingSumSubSequence result= new MaxIncreasingSumSubSequence();
		int maxSum = result.findMaxIncreaseSumSubSequence(arr);
		System.out.println(maxSum);
	}

	int findMaxIncreaseSumSubSequence(int[] arr) {
		int l= arr.length;
		int result[]= new int[l];
		
		for(int i= 0;i<l;i++) {
			result[i]= arr[i];
		}
		
		for(int i= 1;i<l;i++) {
			for(int j= 0;j<i;j++) {
				if(arr[i]>arr[j] && result[j]+arr[i]>result[i]) {
					result[i]= result[j]+arr[i];
				}
			}
		}
		
		int max= Integer.MIN_VALUE;
		for(int i= 0;i<result.length;i++) {
			if(max< result[i]) {
				max= result[i];
			}
		}
		
		return max;
	}
}

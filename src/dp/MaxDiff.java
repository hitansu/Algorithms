package dp;

public class MaxDiff {

	public static void main(String[] args) {
	//	int[] arr= {2, 3, 10, 6, 4, 8, 1};
		int[] arr= {7, 9, 5, 6, 3, 2};
		MaxDiff maxDiff= new MaxDiff();
		Diff diff = maxDiff.findMaxDiff(arr);
		System.out.println("Max diff:: "+diff.maxDiff+" Start ele: "+arr[diff.strtIdx]+" End ele: "+arr[diff.endIdx]);
	}
	
	private Diff findMaxDiff(int[] arr) {
		Diff diff= new Diff();
		diff.maxDiff= 0;
		diff.strtIdx= -1;
		diff.endIdx= -1;
		int n= arr.length;
		if(n== 0) return diff;
		int maxDiff= 0;
		int max= arr[n-1];
		int strtIdx= -1;
		int endIdx= -1;
		for(int i= n-1;i>=0;i--) {
			if(max<arr[i]) {
				max= arr[i];
				endIdx= i;
			}
			if(max-arr[i]>maxDiff) {
				maxDiff= max-arr[i];
				strtIdx= i;
			}
		}
		
		diff.maxDiff= maxDiff;
		diff.strtIdx= strtIdx;
		diff.endIdx= endIdx;
		
		return diff;
	}
	
	class Diff {
		int maxDiff;
		int strtIdx;
		int endIdx;
	}

}

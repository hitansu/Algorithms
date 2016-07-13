package dp;

public class SubSetSum {
	static String s= "";

	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		int s= 10;
		SubSetSum prob= new SubSetSum();
		boolean isPossible= prob.isSumPossible(arr, s);
		System.out.println(isPossible);
		System.out.println(prob.isSumPossibleRec(arr, s, arr.length));
	}
	
	boolean isSumPossible(int[] arr, int s) {
		int n= arr.length;
		boolean[][] sum= new boolean[n][s+1];
		for(int i= 0;i<n;i++) {
			sum[i][0]= true;
		}
		
		for(int i= 1;i<= s;i++) {
			sum[0][i]= arr[0]== i ?true: false;
		}
		
		for(int i= 1;i<n;i++) {
			for(int j= 1;j<=s;j++) {
				sum[i][j]= sum[i-1][j];
				if(j>=arr[i]) {
					sum[i][j]= sum[i][j] || sum[i-1][j-arr[i]]; 
				}
			}
		}
		
		return sum[n-1][s];
	}
	
	boolean isSumPossibleRec(int[]arr, int s, int n) {
		if(n<0) return false;
		if(n==0 && s>0) return false;
		if(s== 0) return true;
		
		return isSumPossibleRec(arr, s, n-1) || isSumPossibleRec(arr, s-arr[n-1], n-1);
		
	}

}

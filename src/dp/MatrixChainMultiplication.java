package dp;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
	//	int[] arr = new int[] {1, 2, 3, 4};
		int[] arr= new int[] {40, 20, 30, 10, 30};
		System.out.println(findCost(arr, 1, arr.length-1));
		System.out.println(findCostItr(arr));
	}
	
	static int findCost(int[] arr, int l, int h) {
		if(l== h)
			return 0;
		int cost= Integer.MAX_VALUE;
		for(int k= l;k<h;k++) {
			int val= findCost(arr, l, k)+findCost(arr, k+1, h)+arr[l-1]*arr[k]*arr[h];
			if(val<cost) {
				cost= val;
			}
		}
		return cost;
	}
	
	static int findCostItr(int[] arr) {
		int n= arr.length;
		int[][] result= new int[n][n];
		for(int i= 1;i<n;i++) {
			result[i][i]= 0;
		}
		for(int l= 2;l<n;l++){
			for(int i= 1;i<=n-l;i++) {
				int j= i+l-1;
				result[i][j]= Integer.MAX_VALUE;
				for(int k= i;k<j;k++) {
					int val= result[i][k]+result[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(val<result[i][j]) {
						result[i][j]= val;
					}
				}
			}
		}
		return result[1][n-1];
	}

}

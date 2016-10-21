package dp;

public class GameStrategy {

	public static void main(String[] args) {
		int[] arr= {5,3,7,10};
		System.out.print(findMaxGamePoint(arr, 0, arr.length-1)+" ");
		System.out.println(findMaxGamePointItr(arr));
		int[] arr1= {8, 15, 3, 7};
		System.out.print(findMaxGamePoint(arr1, 0, arr1.length-1)+" ");
		System.out.println(findMaxGamePointItr(arr1));
	}
	
	static int findMaxGamePoint(int[] arr,int l,int h) {
		if(l== h)
			return arr[l];
		if(l+1== h)
			return Math.max(arr[l], arr[h]);
		return Math.max(arr[l]+Math.min(findMaxGamePoint(arr, l+2, h), findMaxGamePoint(arr, l+1, h-1)), 
											arr[h]+Math.min(findMaxGamePoint(arr, l, h-2), findMaxGamePoint(arr, l+1, h-1)));
	}
	
	static int findMaxGamePointItr(int[] arr) {
		int n= arr.length;
		int[][] result= new int[n][n];
		for(int len= 1;len<=n;len++) {
			for(int i= 0;i<=n-len;i++) {
				int j= i+len-1;
				
				int x= i+2<=j?result[i+2][j]:0;
				int y= i+1<=j-1?result[i+1][j-1]:0;
				int z= i<=j-2?result[i][j-2]:0;
				
				result[i][j]= Math.max(arr[i]+Math.min(x, y), arr[j]+Math.min(z, y)); 
				
			}
		}
		return result[0][n-1];
	}

}

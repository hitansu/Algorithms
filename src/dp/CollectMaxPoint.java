package dp;

/**
 * TODO: Fix it
 * @author jenah
 *
 */
public class CollectMaxPoint {

	public static void main(String[] args) {
		  int[][] arr = {
				  			{3, 6, 8, 2},
				  			{5, 2, 4, 3},
				  			{1, 1, 20, 10},
				  			{1, 1, 20, 10},
				  			{1, 1, 20, 10},
                 		};
		
/*		  int[][] arr = {
		  			{3, 6, 8},
		  			{5, 2, 4},
		  			{1, 8, 20}
       		};*/
		  int r= arr.length;
		  int c= arr[0].length;
		  CollectMaxPoint prob= new CollectMaxPoint();
		  int maxPt = prob.collectMaxPoint(arr, 0, 0, r-1, c-1);
		  System.out.println(maxPt);
	}
	
	private int collectMaxPoint(int[][] arr, int i, int j, int r, int c) {
		int res= 0;
		if(i>r || j>c || i<0 || j<0) return Integer.MIN_VALUE;
		if(i== r && j== 0) return arr[i][j];
		if(i== r && j!= 0) return Integer.MIN_VALUE;
		if(j== 0) {
			int r1= collectMaxPoint(arr, i+1, j, r, c);
			int r2= collectMaxPoint(arr, i+1, j+1, r, c);
			res= res+arr[i][j]+Math.max(r1, r2);
			/*if(r1>r2) arr[i+1][j]= 0;
			else arr[i+1][j+1]= 0;*/
		} else if(j== c-1) {
			int r1= collectMaxPoint(arr, i+1, j-1, r, c);
			int r2= collectMaxPoint(arr, i+1, j, r, c);
			res= res+arr[i][j]+Math.max(r1, r2);
			/*if(r1>r2) arr[i+1][j-1]= 0;
			else arr[i+1][j]= 0;*/
		} else {
			int r1= collectMaxPoint(arr, i+1, j-1, r, c);
			int r2= collectMaxPoint(arr, i+1, j, r, c);
			int r3= collectMaxPoint(arr, i+1, j+1, r, c);
			if(r1>r2 && r1>r3) {
				res= r1+arr[i][j];
				//arr[i+1][j-1]= 0;
				
			} else if(r2>r1 && r2>r3) {
				res= r2+arr[i][j];
			//	arr[i+1][j]= 0;
				
			} else if(r3>r2 && r3>r1) {
				res= r3+arr[i][j];
			//	arr[i+1][j+1]= 0;
				
			}
		}
		
		return res;
		
	}

}

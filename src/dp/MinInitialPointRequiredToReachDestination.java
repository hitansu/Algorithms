package dp;

public class MinInitialPointRequiredToReachDestination {

	public static void main(String[] args) {
		int[][] points = { {-2, -3,   3}, 
                		   {-5, -10,  1}, 
                		   {10,  30, -5} 
              			 };
		
		int[][] points1 = { {-10, -9,   2}, 
	     		   {-5, -15,  4}, 
	     		   {18,  12, -7} 
	   			 };
		int min_point= minPointRequired(points, 0,0,2, 2);
		System.out.println(min_point);
		System.err.println(minPointRequired_1(points, 0, 0, 2, 2, 0, 0));
	}
	
	private static int minPointRequired_1(int[][] a, int i, int j, int m, int n, int req, int val) {
		if(i>m || j>n)
			return Integer.MAX_VALUE;
		if(i== m && j== n) {
			if(val+req+a[i][j]>0) {
				return req;
			} else {
				return Math.abs(val+a[i][j]+req)+1+req;
			}
		}
		if(val+req+a[i][j]<0) {
			req= req+Math.abs(val+a[i][j]+req)+1;
		}
		
		int right= minPointRequired_1(a, i, j+1, m, n, req, val+a[i][j]);
		int down= minPointRequired_1(a, i+1, j, m, n, req, val+a[i][j]);
		
		return Math.min(right, down);
		
	}
	
	private static int minPointRequired(int[][] arr, int x, int y, int m, int n) {
		if(x>m || y>n)
			return Integer.MAX_VALUE;
		if(x== m && y== n) {
			if(arr[x][y]>=0) {
				return 1;
			} else {
				return arr[x][y]*-1+1;
			}
		}
		
		int up= minPointRequired(arr, x+1,y,m, n);
		int left= minPointRequired(arr, x,y+1,m, n);
		int req= Math.min(up, left);
		int res;
		if(arr[x][y]>= req) {
			res= 1;
		}else {
			res= req+arr[x][y]*-1;
		}
		return res;
	}

}

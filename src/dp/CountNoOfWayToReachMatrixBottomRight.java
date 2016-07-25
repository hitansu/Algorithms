package dp;

public class CountNoOfWayToReachMatrixBottomRight {

	public static void main(String[] args) {
	//	int matSize= 3;
		int matSize= 4;
		CountNoOfWayToReachMatrixBottomRight prob= new CountNoOfWayToReachMatrixBottomRight();
		int pathCount = prob.countPath(0, 0, matSize-1);
		System.out.println(pathCount);
		System.out.println(prob.countPathDP(matSize));
		System.out.println(prob.numberOfPaths(matSize-1, matSize-1));
	}
	
	private int countPath(int i, int j, int size) {
		if(i>size || j>size) return 0;
		if(i== size && j== size) return 1;
		return countPath(i+1, j, size) + countPath(i, j+1, size);
	}
	
	private int countPathDP(int size) {
		int[][] path= new int[size][size];
		for(int i= 0;i<size;i++) {
			path[size-1][i]= 1;
		}
		for(int i= 0;i<size;i++) {
			path[i][size-1]= 1;
		}
		for(int i= size-2;i>=0;i--) {
			for(int j= size-2;j>=0;j--) {
				path[i][j]= path[i+1][j]+path[i][j+1]; 
			}
		}
		
		return path[0][0];
	}
	
	int  numberOfPaths(int i, int j)
	{
	   if (i == 0 || j == 0) return 1;
	   return  numberOfPaths(i-1, j) + numberOfPaths(i, j-1);
	}
}

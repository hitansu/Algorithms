package dp;

public class MaxSizeSquareMatrix {

	public static void main(String[] args) {
		  int [][]arr =  {{0, 1, 1, 0, 1}, 
                  		  {1, 1, 0, 1, 0}, 
                  		  {0, 1, 1, 1, 0},
                  		  {1, 1, 1, 1, 0},
                  		  {1, 1, 1, 1, 1},
                  		  {0, 0, 0, 0, 0}};
		
		MaxSizeSquareMatrix maxSizeSquareMatrix= new MaxSizeSquareMatrix();
		Index index = maxSizeSquareMatrix.findMaxSizeSquareMatrix(arr);
		System.out.println("Start row index: "+(index.row-index.max+1) +" Start col index: "+(index.col-index.max+1));
		System.out.println("End row index: "+(index.row) +" End col index: "+(index.col));
	}
	
	Index findMaxSizeSquareMatrix(int [][] arr) {
		int colNo= arr[0].length;
		int rowNo= arr.length;
		
		int [][] aux= new int[rowNo][colNo];
		for(int i= 0;i<colNo;i++) {
			aux[0][i]= arr[0][i];
		}
		
		for(int j= 0;j<rowNo;j++) {
			aux[j][0]= arr[j][0];
		}
		
		int max= Integer.MIN_VALUE;
		int rowIndex= -1;
		int colIndex= -1;
		for(int i= 1; i<rowNo; i++) {
			for(int j= 1; j<colNo; j++) {
				if(arr[i][j]== 1) {
					aux[i][j]= findMin(aux[i-1][j], aux[i][j-1], aux[i-1][j-1])+1;
					if(max< aux[i][j]) {
						max= aux[i][j];
						rowIndex= i;
						colIndex= j;
					}
				}
			}
		}
		
		Index index= new Index(rowIndex, colIndex, max);
		return index;
	}
	
	private int findMin(int i, int j, int k) {
		int small= i;
		if(small> j) small= j;
		if(small> k) small= k;
		
		return small;
	}

	class Index {
		int max;
		int row;
		int col;
		
		public Index(int row, int col, int max) {
			this.row= row;
			this.col= col;
			this.max= max;
		}
	}

}

package dp;

public class MaxSumRectangle {

	public static void main(String[] args) {
		int[][] arr= {
						{1, 2, -1, -4, -20},
                		{-8, -3, 4, 2, 1},
                		{3, 8, 10, 1, 3},
                		{-4, -1, 1, 7, -6}
               		};
		
		/*int[][] arr= {
						{-10, 100, 50, -200},
						{100, 10, -50, 50},
						{200, 300, 400, 500},
						{600, 700, 800, 900}
					};*/
		
		MaxSumRectangle prob= new MaxSumRectangle();
		Result result = prob.findMaxSumRectangle(arr);
		
		printResultMatrix(arr, result);
	}
	
	private static void printResultMatrix(int[][] arr, Result result) {
		int rowSt= result.rowSt;
		int rowEn= result.rowEn;
		int colSt= result.colSt;
		int colEn= result.colEn;
		
		int sum= 0;
		for(int i= rowSt; i<= rowEn; i++) {
			for(int j= colSt; j<= colEn; j++) {
				System.out.print(arr[i][j]+" ");
				sum+= arr[i][j];
			}
			System.out.println("");
		}
		
		System.out.println("Sum is: "+sum);
	}

	Result findMaxSumRectangle(int[][] arr) {
		int rowN= arr.length;
		int colN= arr[0].length;
		
		/*first find the column boundary using kadane's theorem*/
		int MAX_SUM= Integer.MIN_VALUE;
		int colEnIndex= 0;
		int colStIndex= 0;
		for(int i= 0;i<colN;i++) {
			int SUM= 0;
			for(int j= 0;j<rowN;j++) {
				SUM+= arr[j][i];
			}
			if(MAX_SUM>0 && MAX_SUM+SUM> MAX_SUM) {
				MAX_SUM= MAX_SUM+SUM;
				colEnIndex= i;
			} else if(MAX_SUM<0 && SUM>MAX_SUM) {
				MAX_SUM= SUM;
				colStIndex= i;
				colEnIndex= i;
			}
		}
		
		/*Second find the row boundary using kadane's theorem*/
		MAX_SUM= Integer.MIN_VALUE;
		int rowEnIndex= 0;
		int rowStIndex= 0;
		for(int i= 0;i<rowN;i++) {
			int SUM= 0;
			for(int j= colStIndex;j<=colEnIndex;j++) {
				SUM+= arr[i][j];
			}
			if(MAX_SUM>0 && MAX_SUM+SUM> MAX_SUM) {
				MAX_SUM= MAX_SUM+SUM;
				rowEnIndex= i;
			} else if(MAX_SUM<0 && SUM>MAX_SUM) {
				MAX_SUM= SUM;
				rowStIndex= i;
				rowEnIndex= i;
			}
		}
		
	//	System.out.println("("+rowStIndex+","+colStIndex+")"+" ,"+ "("+rowEnIndex+","+colEnIndex+")");
		
		
		Result r= new Result(rowStIndex, rowEnIndex, colStIndex, colEnIndex);
		return r;
	}
	
	class Result {
		int rowSt, rowEn;
		int colSt, colEn;
		
		public Result(int rowSt, int rowEn, int colSt, int colEn) {
			this.rowSt= rowSt;
			this.rowEn= rowEn;
			this.colSt= colSt;
			this.colEn= colEn;
		}
	}

}

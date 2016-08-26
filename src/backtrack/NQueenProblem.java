package backtrack;

public class NQueenProblem {

	public static void main(String[] args) {

		int[][] board= {
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0},
						{0, 0, 0, 0}
						};
		int N= board.length;
		
		boolean isSolvable= isSolvable(board, 0, N);
		System.out.println("The problem is solvable:: "+isSolvable);
		printThePath(board);
	}
	
	private static void printThePath(int[][] board) {

		int n= board.length;
		for(int i= 0;i<n;i++) {
			for(int j= 0;j<n;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}

	private static boolean isSolvable(int[][] board, int col, int N) {
		if(col>= N) return true;
		for(int i= 0;i<N;i++) {
			if(isSafe(board,i,col, N)) {
				board[i][col]= 1;
				if(isSolvable(board, col+1, N)) {
					return true;
				}
				board[i][col]= 0; // back tracking
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col, int N) {
		for(int i= 0;i<col;i++) {
			if(board[row][i]== 1) {
				return false;
			}
		}
		//check for diagonal
		for(int i= row,j= col;i>= 0 && j>= 0;i--,j--) {
			if(board[i][j]== 1) {
				return false;
			}
		}
		for(int i= row,j= col;i<N && j>= 0;i++,j--) {
			if(board[i][j]== 1) {
				return false;
			}
		}
		
		return true;
	}

}

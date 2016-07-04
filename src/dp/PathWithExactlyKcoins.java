package dp;

import java.util.Iterator;
import java.util.Stack;

public class PathWithExactlyKcoins {

	 int[][] mat= { {1, 2, 3},
                    {4, 6, 5},
                    {3, 2, 1}
                  };
	
	public static void main(String[] args) {
		PathWithExactlyKcoins path= new PathWithExactlyKcoins();
		int i,j= path.mat[0].length;
		i= j;
		int k= 12;
		int pathCount= path.countPath(path.mat, i-1, j-1, k);
		System.out.println(pathCount);
	}
	
	int countPath(int[][] mat, int i, int j, int k) {
		if(i<0 || j<0 || k<0) return 0;
		if(i== 0 && j== 0) {
			if(mat[0][0]== k) {
				return 1;
			} else {
				return 0;
			}
		}
		Stack st= new Stack<>();
		return countPathUtils(mat, i, j, k, st);
	}
	
	int countPathUtils(int[][]mat, int i, int j, int k, Stack st) {
		if(i<0 || j<0) return 0;
		if(k<0) return 0;
		if(i== 0 && j== 0) {
			if(mat[i][j]== k) {
				st.push(mat[i][j]);
				printPath(st);
				st.pop();
				return 1;
			}
			else return 0;
		}
		
		st.push(mat[i][j]);
		int count= countPathUtils(mat, i-1, j, k-mat[i][j], st);
		st.pop();
		st.push(mat[i][j]);
		count+= countPathUtils(mat, i, j-1, k-mat[i][j], st);
		st.pop();
		return count;
		
		//return countPathUtils(mat, i-1, j, k-mat[i][j]) + countPathUtils(mat, i, j-1, k-mat[i][j]);
		
	}

	private void printPath(Stack st) {
		Iterator iterator = st.iterator();
		while(iterator.hasNext()) {
			System.out.print("->" + iterator.next());
		}
		System.out.println("");
	}

}

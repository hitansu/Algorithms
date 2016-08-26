package backtrack;

public class RatInAMaze {

	static int[][] path;
	public static void main(String[] args) {
		int[][] maze= {
						{1,0,0,0},
						{1,1,0,1},
						{0,1,0,0},
						{1,1,1,1}
					};
		int N= maze.length;
		path= new int[N][N];
		if(isReachable(maze, 0, 0, N)) {
			printPath(N);
		}
		
	}
	
	static void printPath(int N) {
		for(int i= 0;i<N;i++) {
			for(int j= 0;j<N;j++) {
				System.out.print(path[i][j]+" ");
			}
			System.out.println("");
		}
	}

	static boolean isReachable(int[][] maze, int i, int j, int N) {
		if(isAllowed(maze, i, j, N)) {
			path[i][j]= 1;
			if(i== N-1 && j== N-1) return true;
			if(isReachable(maze, i+1, j, N)) {
				return true;
			}
			if(isReachable(maze, i, j+1, N)) {
				return true;
			}
			path[i][j]= 0;
		}
		return false;
	}

	static boolean isAllowed(int[][] maze, int i, int j, int N) {
		if(i<0 || j<0 || i>= N || j>= N) {
			return false;
		}
		if(maze[i][j]== 0) {
			return false;
		}
		return true;
	}

}

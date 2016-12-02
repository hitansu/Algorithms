package dp;

public class CountPathFromSrcToDst {

	public static void main(String[] args) {
		   int graph[][] =new int[][] { {0, 1, 1, 1},
	            						{0, 0, 0, 1},
	            						{0, 0, 0, 1},
	            						{0, 0, 0, 0}
	        						};
		CountPathFromSrcToDst prob= new CountPathFromSrcToDst();
		int pathCount = prob.countPath(graph, 0, 3, 2);
		System.out.println(pathCount);
	}
	
	private int countPath(int[][] graph, int u, int v, int k) {
		if(v== u && k> 0) return 0;
		if(u== v && k== 0) return 1;
		int l= graph.length;
		int count= 0;
		for(int i= 0;i<l;i++) {
			if(graph[u][i]== 1) {
				count+= countPath(graph, i, v, k-1);
			}
		}
		
		return count;
	}

}

package disjointSet;

public class PrimMSTGreedy {

	private void printMST(int[][] graph) {
		int vCount= graph.length;
		boolean []mst= new boolean[vCount];
		int []key= new int[vCount];
		int []parent= new int[vCount];
		
		for(int i= 0;i< vCount;i++) {
			key[i]= Integer.MAX_VALUE;
			parent[i]= -1;
			mst[i]= false;
		}
		
		key[0]= 0;
		
		for(int i= 0;i< vCount;i++) {
			int minV= findMin(key, mst);
			mst[minV]= true;
			for(int j= 0; j< vCount;j++) {
				if(graph[minV][j]<Integer.MAX_VALUE && graph[minV][j]!= 0 && graph[minV][j]< key[j] && !mst[j]) {
					key[j]= graph[minV][j];
					parent[j]= minV;
				}
			}
		}
		
		printMST(parent, graph);
		
	}
	
	void printMST(int parent[], int graph[][])
	{
	   int v= graph.length;
	   for (int i = 1; i <v; i++)
	      System.out.println(""+parent[i]+","+ i+", "+graph[i][parent[i]]);
	}
	
	private static int findMin(int []key, boolean []mst) {
		int v= key.length;
		int min= Integer.MAX_VALUE;
		int minIndex= -1;
		for(int i= 0;i<v;i++ ) {
			if(key[i]< min && !mst[i]) {
				min= key[i];
				minIndex= i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		/*input taken from geeksforgeeks*/
		 /* Let us create the following graph
        	2    3
    		(0)--(1)--(2)
     		|   / \   |
    	   6| 8/   \5 |7
     		| /     \ |
    		(3)-------(4)
          			9          */
		int graph[][] = new int[][]{	{0, 2, 0, 6, 0},
                                    	{2, 0, 3, 8, 5},
                                    	{0, 3, 0, 0, 7},
                                    	{6, 8, 0, 0, 9},
                                    	{0, 5, 7, 9, 0},
                   					};
                   					
        PrimMSTGreedy primGreedy= new PrimMSTGreedy();
        System.out.println(graph.length);
        System.out.println(graph[0].length);
        primGreedy.printMST(graph);
	}

	

}

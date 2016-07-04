package dp;

import java.util.Deque;
import java.util.LinkedList;

public class FlyodWarshall {
	public static int MAX_VALUE= 1000;

	public static void main(String[] args) {
        int[][] graph = {
                			{0,   3,   6,   15},
                			{MAX_VALUE, 0,  -2,   MAX_VALUE},
                			{MAX_VALUE, MAX_VALUE, 0,   2},
                			{1,   MAX_VALUE, MAX_VALUE, 0}
        				};
		
		FlyodWarshall flyodWarshall= new FlyodWarshall();
		Result result = flyodWarshall.allPathShortestPath(graph);
		int l = result.dist.length;
		for(int i= 0;i<l;i++) {
			for(int j= 0;j<l;j++) {
				if(j== 0) {
					System.out.print(result.dist[i][j]== MAX_VALUE?"NA":result.dist[i][j]);
				} else {
					
					System.out.print(","+(result.dist[i][j]== MAX_VALUE?"NA":result.dist[i][j]));
				}
				
			}
			System.out.println("");
		}
		
		printPath(result.path, 3, 2);
	}
	
	private static void printPath(int[][] path, int strt, int end) {
		Deque<Integer> stack = new LinkedList<>();
		stack.addFirst(end);
		while(true) {
			end= path[strt][end];
			stack.addFirst(end);
			if(end== -1) {
				return;
			}
			
			if(end== strt) {
				break;
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pollFirst() +" ");
		}
	}

	Result allPathShortestPath(int[][] graph) {
		Result result= new Result();
		int n= graph.length;
		int [][]dist= new int[n][n];
		int [][]path= new int[n][n];
		
		for(int i= 0;i<n;i++) {
			for(int j= 0;j<n;j++) {
				dist[i][j]= graph[i][j]; 
				if(graph[i][j]!= MAX_VALUE || i!= j) {
					path[i][j]= i;
				} else {
					path[i][j]= -1;
				}
			}
		}
		
		for(int k= 0;k<n;k++) {
			for(int i= 0;i<n;i++) {
				for(int j= 0;j<n;j++) {
					if(dist[i][k]== MAX_VALUE || dist[k][j]== MAX_VALUE) continue;
					if(dist[i][k]+dist[k][j]<dist[i][j]) {
						dist[i][j]= dist[i][k]+dist[k][j];
						path[i][j]= path[k][j]; 
					}
				}
			}
		}
		
		result.dist= dist;
		result.path= path;
		
		return result;
	}
	
	class Result {
		int[][] path;
		int[][] dist;
	}

}

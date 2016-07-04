package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import graph.Graph.Vertex;

public class DFS {

	public void dfs(Graph<Integer> graph) {
		List<Vertex<Integer>> allVertex = graph.getAllVertex();
		Set<Integer> visited= new HashSet<>();
		for(Vertex<Integer> v: allVertex) {
			if(!visited.contains(v.getId())) {
				dfsUtil(v, visited);
			}
		}
	}
	
	private void dfsUtil(Vertex<Integer> v, Set<Integer> visited) {
		visited.add(v.getId());
		System.out.println(v.getId()+ " ");
		for(Vertex<Integer> adjV: v.getAdjacentVertex()) {
			if(!visited.contains(adjV.getId())) {
				dfsUtil(adjV, visited);
			}
		}
		
	}

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 6);
		graph.addEdge(6, 5);
		graph.addEdge(5, 3);
		
		DFS dfs= new DFS();
		dfs.dfs(graph);
	}
}

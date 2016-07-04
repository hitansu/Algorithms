package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import graph.Graph.Vertex;

public class BFS {

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 6);
		graph.addEdge(6, 5);
		graph.addEdge(5, 3);
		
		BFS bfs= new BFS();
		bfs.bfs(graph);
	
	}

	private void bfs(Graph<Integer> graph) {
		Queue<Vertex<Integer>> q= new LinkedList<>();
		Set<Integer> visited= new HashSet<>();
		List<Vertex<Integer>> allVertex = graph.getAllVertex();
		for(Vertex<Integer> v: allVertex) {
			if(!visited.contains(v.getId())) {
				bfsUtil(visited, v, q);
			}
		}
		
	}

	private void bfsUtil(Set<Integer> visited, Vertex<Integer> v, Queue<Vertex<Integer>> q) {
		visited.add(v.getId());
		q.add(v);
		while(!q.isEmpty()) {
			Vertex<Integer> poll = q.poll();
			System.out.println(poll.getId()+ " ");	
				for(Vertex<Integer> adjVertex: poll.getAdjacentVertex()) {
					if(!visited.contains(poll.getId())) {
						visited.add(poll.getId());
						q.add(adjVertex);
					}
					
				}
			}
		}
		
	}


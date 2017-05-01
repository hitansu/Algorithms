package amazon_alexa;

/**
 * Question:
 * 
 *  In a country the cities are connected through roads of 3 types 1, 2, 3.
	All the roads are bi-directional. The roads of a city has some restriction.
	Road of type 3: both men and women can walk
	Road of type 2: only women can walk
	Road of type 1: only men can walk
	Now the govt. wants to remove extra roads.But the cities should be connected for both men & women.
	Connected means one should able to reach from one city to other & vice-versa.
	Find out the maximum no of roads can be removed so that the cities can be accessible to both men & women.
	Input:
	5 5
	1 2 3
	2 3 3
	3 4 3
	5 3 2
	5 4 1
	First line gives no of cities & no of roads. Next each 5 lines gives city source, city destination, type for a roads.
	5: no of cities 5: no of roads
	1: city 2   2: city 2    3: type 3 road

	o/p: 2
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Source1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Read the variable from STDIN
        int no_of_city = in.nextInt();
        int no_of_road= in.nextInt();
        // Output the variable to STDOUT
        Graph g= new Graph(no_of_city);
        for(int i= 0;i<no_of_road;i++) {
        	int src= in.nextInt();
        	int dst= in.nextInt();
        	int type= in.nextInt();
        	g.addEdge(src, dst, type);
        }
        
        int result= g.solve();
        System.out.println(result);

	}
	
	static class Graph {
		int v;
		// Keep track of node for Union-Find
		Map<Integer, Node> nodeMap;
		// Edge corresponding to Type-1,2,3 road
		LinkedList<Edge>[] edgeMap;
		// adjacent vertex info for each vertex
		LinkedList<Edge>[] adjV;
		// keep track of all visited vertex
		boolean[] visited;
		int road_types= 3;
		
		public Graph(int v) {
			nodeMap= new HashMap<>();
			visited= new boolean[v+1];
			Arrays.fill(visited, false);
			adjV= new LinkedList[v+1];
			this.v= v;
			edgeMap= new LinkedList[road_types+1];
			initializeAdjV();
			buildEdgeMap();
			makeSet();
		}
		
		private void initializeAdjV() {
			for(int i= 1;i<= v;i++) {
				adjV[i]= new LinkedList<>();
			}
		}

		public int solve() {
			// first check if it is connected
			if(!isConnected()) {
				return -1;
			}
			
			int count= 0;
			Set<Integer> commonVertices= new HashSet<>();// road Type-3
			Set<Integer> exclusiveVertices= new HashSet<>(); // road Type-1 or 2
			
			// first make set with type 3 roads & detect cycle
			{
				LinkedList<Edge> type3Roads = edgeMap[3];
				for(Edge edge: type3Roads) {
					int src= edge.src;
					int dst= edge.dst;
					commonVertices.add(src);
					commonVertices.add(dst);
					
					Node nodeSrc = findSet(src);
					Node nodeDst = findSet(dst);
					if(nodeSrc.data== nodeDst.data) {
						count++;
					} else {
						union(src, dst);
					}
				}
			}
			
			// make set with type 2 roads & detect cycle
			{
				LinkedList<Edge> type2Roads = edgeMap[2];
				for(Edge edge: type2Roads) {
					int src= edge.src;
					int dst= edge.dst;
					exclusiveVertices.add(src);
					exclusiveVertices.add(dst);
					
					Node nodeSrc = findSet(src);
					Node nodeDst = findSet(dst);
					if(nodeSrc.data== nodeDst.data) {
						count++;
					} else {
						union(src, dst);
					}
				}
			}
			
			// undo the type 2 road changes
			for(Integer i: exclusiveVertices) {
				makeSet(i);
			}
			exclusiveVertices.clear();
			
			// make set with type 1 roads & detect cycle
			{
				LinkedList<Edge> type1Roads = edgeMap[1];
				for(Edge edge: type1Roads) {
					int src= edge.src;
					int dst= edge.dst;
					exclusiveVertices.add(src);
					exclusiveVertices.add(dst);
					
					Node nodeSrc = findSet(src);
					Node nodeDst = findSet(dst);
					if(nodeSrc.data== nodeDst.data) {
						count++;
					} else {
						union(src, dst);
					}
				}
			}
			
			return count;			
		}

		private boolean isConnected() {
			// first check for men
			dfs(1, true);
			for(int i= 1;i<= v;i++) {
				if(visited[i]== false) {
					return false;
				}				
			}
			Arrays.fill(visited, false);
			// check for women
			dfs(1, false);
			for(int i= 1;i<= v;i++) {
				if(visited[i]== false) {
					return false;
				}				
			}
			
			return true;
		}

		private void dfs(int i, boolean isMen) {
			visited[i]= true;
			LinkedList<Edge> adjEdges = adjV[i];
			for(Edge edge: adjEdges) {
				int adjVertex= 0;
				if(edge.src!= i) {
					adjVertex= edge.src;
				} else if(edge.dst!= i) {
					adjVertex= edge.dst;
				}
				if(isSafe(adjVertex, edge.type, isMen)) {
					dfs(adjVertex, isMen);
				}
			}	
		}

		private boolean isSafe(int adjVertex, int type, boolean isMen) {
			if(visited[adjVertex]== true) return false;
			if(type== 3 || (isMen && type== 1) || (!isMen && type== 2)) return true;
			return false;
		}

		public void addEdge(int src, int dst, int type) {
			Edge edge= new Edge(src, dst, type);
			edgeMap[type].add(edge);
			adjV[src].add(edge);
			adjV[dst].add(edge);
		}

		private void buildEdgeMap() {
			for(int i= 1;i<= 3;i++) {
				edgeMap[i]= new LinkedList<>();
			}
		}

		private void makeSet() {
			for(int i= 1;i<= v;i++) {
				makeSet(i);
			}
			
		}
		
		private void makeSet(int i) {
			Node node= new Node();
			node.data= i;
			node.rank= 0;
			node.parent= node;
			
			nodeMap.put(i, node);
		}
		
		private Node findSet(int i) {
			Node node = nodeMap.get(i);
			if(node.parent.data== i) {
				return node;
			}
			node.parent= findSet(node.parent.data);
			
			return node.parent;
		}
		
		private void union(int i, int j) {
			Node n1= findSet(i);
			Node n2= findSet(j);
			if(n1.data== n2.data) {
				return;
			}
			if(n1.rank>= n2.rank) {
				n2.parent= n1;
				n1.rank= n1.rank== n2.rank ? n1.rank+1 : n1.rank;
			} else {
				n1.parent= n2;
			}
		}
	
	}
	
	static class Node {
		public int data= Integer.MIN_VALUE;
		public int rank= Integer.MIN_VALUE;
		public Node parent= null;
	}

	static class Edge {
		
		int src, dst, type;
		
		public Edge(int src, int dst, int type) {
			this.src= src;
			this.dst= dst;
			this.type= type;
		}
	}
}

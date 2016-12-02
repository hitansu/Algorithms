package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * graph question grab
 * @author jenah
 *
 */

public class Test3 {

	public static void main(String[] args) {
		int[] T= {9, 1, 4, 9, 0, 4, 8, 9, 0, 1};
		int[] solve = solve(T);
		System.out.println("length: "+solve.length);
		for(int i: solve) {
			System.out.print(i+ " ");
		}

	}

	public static  int[] solve(int[] T) {
		
		Graph1<Integer> graph = new Graph1<>(false);
		int capital_index= -1;
		for(int i= 0;i<T.length;i++) {
			if(T[i]== i) {
				capital_index= i;
			}
			graph.addEdge(i, T[i]);
		}
		Set<Integer> visited= new HashSet<>();
		Graph1.Vertex<Integer> v = graph.getVertex(capital_index);
		int[] dist= new int[T.length-1];
		int[] tmpDistCount= new int[T.length];
		dfsUtil(v, visited, 0, tmpDistCount);
		for(int i=1; i<tmpDistCount.length;i++) {
			dist[i-1]= tmpDistCount[i];
		}
		return dist;
		
	}
	
	private static void dfsUtil(Graph1.Vertex<Integer> v, Set<Integer> visited, int d, int[] dist) {
		visited.add(v.getId());
		if(d!= 0) {
			dist[d]= dist[d]+1;
		}
		
		int di= d;
		for(Graph1.Vertex<Integer> adjV: v.getAdjacentVertex()) {
			if(!visited.contains(adjV.getId())) {
				dfsUtil(adjV, visited, di+1, dist);
			}
		}
		
	}
	
	
	/*******  CREATING GRAPH STRUCTURE ********/
	static class Graph1<T> {

		boolean isDirected= false;
		Set<Edge<T>> allEdges= new HashSet<>();
		Map<Integer, Vertex<T>> vertexMap= new HashMap<>();
		
		public Graph1(boolean isDirected) {
			this.isDirected= isDirected;
		}
		
		public List<Vertex<T>> getAllVertex() {
			return new ArrayList<>(vertexMap.values());
		}
		
		public void addEdge(int vertexId1, int vertexId2) {
			Vertex<T> v1= getVertex(vertexId1);
			Vertex<T> v2= getVertex(vertexId2);
			Edge<T> e= new Edge<T>(v1, v2);
			allEdges.add(e);
			v1.addAdjacentVertex(e, v2);
			if(!isDirected) {
				v2.addAdjacentVertex(e, v1);
			}
			
		}

		public Vertex<T> getVertex(int vertexId1) {
			Vertex<T> v1;
			if(vertexMap.containsKey(vertexId1)) {
				v1= vertexMap.get(vertexId1);
			} else {
				v1= new Vertex<>(vertexId1);
				vertexMap.put(vertexId1, v1);
			}
			return v1;
		}
		

		static class Edge<T> {
			Vertex<T> src;
			Vertex<T> dst;
			int wt= 0;
			
			public Edge(Vertex<T> src, Vertex<T> dst) {
				this.src= src;
				this.dst= dst;
			}
			
			public Edge(Vertex<T> src, Vertex<T> dst, int wt) {
				this.src= src;
				this.dst= dst;
				this.wt= wt;
			}
			
			@Override
			public int hashCode() {
		        final int prime = 31;
		        int result = 1;
		        result = prime * result + ((src == null) ? 0 : src.hashCode());
		        result = prime * result + ((dst == null) ? 0 : dst.hashCode());
		        return result;
		    }
			
			@Override
			public boolean equals(Object obj) {
				if(null == obj) return false;
				if(!(obj instanceof Edge)) return false;
				Edge that= (Edge) obj;
				if(that.src== null || that.dst== null || this.src== null || this.dst== null) return false;
				if(!(that.src.equals(this.src)) || !(that.dst.equals(this.dst))) return false;
				return true;
			}
		}
		
		static class Vertex<T> {
			T data;
			int id;
			Set<Edge<T>> adjEdge= new HashSet<>();
			Set<Vertex<T>> adjVertex= new HashSet<>();
			
			public Vertex(int id) {
				this.id= id;
			}
			
			public void setData(T data) {
				this.data= data;
			}
			
			public T getData() {
				return data;
			}
			
			public int getId() {
				return id;
			}
			
			public void addAdjacentVertex(Edge<T> e, Vertex<T> v2) {
				adjEdge.add(e);
				adjVertex.add(v2);
			}
			
			public Set<Vertex<T>> getAdjacentVertex() {
				return adjVertex;
			}
			
			@Override
			public int hashCode() {
		        final int prime = 31;
		        int result = 1;
		        result = prime * result + (int) (id ^ (id >>> 32));
		        return result;
		    }
			
			@Override
			public boolean equals(Object obj) {
				if(null== obj) return false;
				if(!(obj instanceof Vertex)) return false;
				Vertex that= (Vertex) obj;
				if(that.id!= this.id) return false;
				
				return true;
				
			}
			
		}
	}	
	
	
}

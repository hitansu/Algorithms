package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

	boolean isDirected= false;
	Set<Edge<T>> allEdges= new HashSet<>();
	Map<Integer, Vertex<T>> vertexMap= new HashMap<>();
	
	public Graph(boolean isDirected) {
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

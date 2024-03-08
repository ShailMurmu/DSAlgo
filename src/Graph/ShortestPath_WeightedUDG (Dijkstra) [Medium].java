package Graph;

import java.util.ArrayList;
import java.util.Stack;

class GraphDijkstra {
	int Cap;
	ArrayList<Pair>[] adj;
	GraphDijkstra(int cap){
		this.Cap = cap;
		
		this.adj = new ArrayList[cap];
		for(int i=0; i<cap; i++) {
			this.adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int u, int v, int w) {
		adj[u].add(new Pair(v, w));
		adj[v].add(new Pair(u, w));
	}
	
	public void dispGraph() {
		for(int i=0; i<Cap; i++) {
			System.out.print("("+i+") -> ");
			for(Pair p: adj[i]) {
				System.out.print("("+p.key+", "+p.val+")");
			}
			System.out.println();
		}
	}
}

/*  Single Source
 *  Shortest Path in Weighted Undirected Graph
 *  (Dijkstra's Algorithm)
 * 
 *  Time Complexity: O(E + V)
 *  Space Complexity: O(E + V)
 */


class ShortestPath_WeightedUDG {

	public static void main(String[] args) {
		GraphDijkstra g = new GraphDijkstra(4);
		
		// Build adjacency graph
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 8);
		g.addEdge(1, 2, 9);
		g.addEdge(1, 3, 2);
		g.addEdge(2, 3, 6);
		
		g.dispGraph();
		
		// Initialise dist[] with inf and vis[] with false;
		int src = 1;
		int[] dist = new int[g.Cap];
		boolean[] vis = new boolean[g.Cap];
		for(int i=0; i<g.Cap; i++) dist[i] = Integer.MAX_VALUE;
		
		dist[src] = 0;
		Stack<Pair> s = new Stack<>();
		s.push(new Pair(src,0));
		
		// traverse all node to update dist[]
		while(!s.isEmpty()) {
			Pair top = s.pop();
			vis[top.key] = true;
			
			for(Pair neighbour: g.adj[top.key]) {
				
				if(dist[top.key]+neighbour.val < dist[neighbour.key]) {
					dist[neighbour.key] = dist[top.key]+neighbour.val;
					if(!vis[neighbour.key]) s.push(neighbour);
				}
				
			}
		}
		
		for(int i=0; i<g.Cap; i++) System.out.print(dist[i]+" ");
		
	}

}
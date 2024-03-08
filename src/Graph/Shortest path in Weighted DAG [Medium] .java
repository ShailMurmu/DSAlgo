package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Pair{
	int key;
	int val;
	
	Pair(int k, int v){
		this.key = k;
		this.val = v;
	}
}

class InnerGraph {
	int Cap;
	Map<Integer, ArrayList<Pair> > adj;

	InnerGraph(int cap){
		this.Cap = cap;
		this.adj = new HashMap<>();
	}
	
	public void addEdge(int u, int v, int w) {
		if(adj.get(u) == null) {
			ArrayList<Pair> temp = new ArrayList<>();
			temp.add(new Pair(v, w));
			adj.put(u, temp);
		}
		else {
			adj.get(u).add(new Pair(v,w));
		}
	}
	
	public void dispGraph() {
		for(Map.Entry<Integer, ArrayList<Pair> > elem: adj.entrySet()) {
			System.out.print("("+ elem.getKey() +") -> ");
			for(Pair p: elem.getValue()) {
				System.out.print("("+ p.key +", "+ p.val +")");
			}
			System.out.println();
		}
	}
	
	public void dfs(int src, Stack<Integer> s, boolean[] vis) {
		vis[src] = true;
		
		if(adj.get(src) != null) {
			for(Pair p: adj.get(src)) {
				if(!vis[p.key]) {
					dfs(p.key, s, vis);
				}
			}
		}
		
		s.push(src);
	}
}


/*	Single Source
 *  Shortest Path in Weighted Directed Graph (DAG)
 * 
 *  Time Complexity: O(E + V)
 *  Space Complexity: O(E + V)
 */


class GraphMain {

	public static void main(String[] args) {
		InnerGraph g = new InnerGraph(6);
		
		//1.  Build adjacency graph
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);
		
		g.dispGraph();
		
		Stack<Integer> s = new Stack<>();
		boolean[] vis = new boolean[g.Cap];
		
		///2.  Get Topological sorting of graph
		for(int i=0; i<g.Cap; i++) {
			if(!vis[i]) {
				g.dfs(i, s, vis);
			}
		}
		
		int src = 1;
		int[] dist = new int[g.Cap];
		for(int i=0; i<g.Cap; i++) dist[i] = Integer.MAX_VALUE;
		
		dist[src] = 0;
		
		// traverse through topo sorted node and calc distances 
		while(!s.isEmpty()) {
			int top = s.pop();
			
			if(g.adj.get(top) != null) {
				for(Pair p: g.adj.get(top)) {
					if(dist[top] != Integer.MAX_VALUE && dist[top] + p.val < dist[p.key]) {
						dist[p.key] = dist[top] + p.val;
					}
				}
			}
			
		}
		
		
		for(int i=0; i<g.Cap; i++) System.out.print(dist[i]+" ");
	}

}

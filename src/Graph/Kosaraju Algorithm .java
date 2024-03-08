package Graph;

import java.util.ArrayList;
import java.util.Stack;
/*
A directed graph is strongly connected if there is a path between all pairs of vertices. 
A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph.

Time Complexity - O(V + E)

*/

class StronglyConnected {
    public static void main(String[] args) {
        int n=5;
        ArrayList<Integer>[] adj = new ArrayList[n];
        ArrayList<Integer>[] transpose = new ArrayList[n];
        boolean[] vis = new  boolean[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            transpose[i] = new ArrayList<>();
            vis[i] = false;
        }

        // adj list
        adj[0].add(1);
        adj[0].add(3);
        adj[1].add(2);
        adj[2].add(0);
        adj[3].add(4);

        //1. find toposort of a graph
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, adj, s);
            }
        }

        //2. transpose the adj list (edges of graph)
        for(int i=0; i<n; i++){
            vis[i] = false;
            for(Integer nbr: adj[i]){
                transpose[nbr].add(i);
            }
        }

        //3. call the revDfs and count SCC for above topo order
        int count = 0;
        while(!s.isEmpty()){
            Integer top = s.pop();

            if(!vis[top]) {
                count++;
                revDfs(top, vis, transpose);
            }
        }
        
        System.out.println(count);
    }

    // for toposort
    public static void dfs(int node, boolean[] vis, ArrayList<Integer>[] adj, Stack<Integer> s){
        vis[node] = true;

        for(Integer nbr: adj[node]){
            if(!vis[nbr]) dfs(nbr, vis, adj, s);
        }

        s.push(node);
    }

    // for SCC nodes
    public static void revDfs(int node, boolean[] vis, ArrayList<Integer>[] adj){
        vis[node] = true;

        for(Integer nbr: adj[node]){
            if(!vis[nbr]) revDfs(nbr, vis, adj);
        }
    }
}


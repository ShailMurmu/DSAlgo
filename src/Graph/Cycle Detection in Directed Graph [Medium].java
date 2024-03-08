package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class CD_D_Solution {

    // Cycle detection using DFS
    // Time complexity - O(E + V)
    public static boolean detectCycleInDirectedGraph1(int n, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
        
        for(ArrayList<Integer> edge: edges){
            adj[edge.get(0)].add(edge.get(1));
        }
        
        
        boolean[] visited = new boolean[n+1];
        boolean[] inpath = new boolean[n+1];
        
        // call DFS for all vertices to check cycle
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                if(isCycleDFS(i, adj, visited, inpath)) return true;
            }
        }
    
        return false;
    }

    // DFS - recursively visit all the connected node and mark them visited
    public static boolean isCycleDFS(int node, ArrayList<Integer>[] adj, boolean[] visited, boolean[] inpath) {
        visited[node] = true;
        inpath[node] = true;
        
        for(Integer neighbour: adj[node]){
            if(!visited[neighbour]){
                if(isCycleDFS(neighbour, adj, visited, inpath)) return true;
            }else if(inpath[neighbour]){
                return true;
            }
        }
        
        inpath[node] = false;
        return false;
    }



    // Cycle detection using BFS
    // Time complexity - O(E + V)
    public static boolean detectCycleInDirectedGraph2(int n, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
        
        for(ArrayList<Integer> edge: edges){
            adj[edge.get(0)].add(edge.get(1));
        }
        
        return isCycleBFS(n, adj);
    }
    
    
    
    public static boolean isCycleBFS(int v, ArrayList<Integer>[] adj){
        // Kahn's algorithm
        //count indegees of nodes
        int[] indeg = new int[v+1];
        for(int i=1; i<=v; i++){
            for(Integer node: adj[i]){
                indeg[node]++;
            }
        }
        
        // put all 0-degree node in queue
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1; i<=v; i++){
            if(indeg[i] == 0) q.add(i);
        }
        
        // do BFS traversal
        int count = 0;
        while(!q.isEmpty()){
            Integer front = q.poll();
            count++;
            
            for(Integer neighbour: adj[front]){
                indeg[neighbour]--;
                if(indeg[neighbour] == 0) q.add(neighbour);
            }
        }
        
        if(count == v) return false;
        else return true;
    }
}
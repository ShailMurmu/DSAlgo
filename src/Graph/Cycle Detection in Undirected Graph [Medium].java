package Graph;

import java.util.*;

class CD_UD_Solution {
    
    // Over all Time Complexity - O(E + V)
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++) adj[i] = new ArrayList<Integer>();
        
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        boolean visited[] = new boolean[n+1];
        int parent[] = new int[n+1];
        
        // O(V)
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                if(isCycleDFS(i, -1, adj, visited)) return "Yes";
            }
        }
        
        return "No";
    }
    
    // BFS Method to detect cycle in Graph
    // TC - O(E)
    public static boolean isCycleBFS(int i, ArrayList<Integer>[] adj, boolean[] visited, int[] parent){
        Queue<Integer> q = new LinkedList<Integer>();
        
        parent[i] = -1;
        q.add(i);
        
        int curr;
        while(!q.isEmpty()){
            curr = q.poll();
            visited[curr] = true;
            
            for(Integer neighbor: adj[curr]){
                if(!visited[neighbor]){
                    parent[neighbor] = curr;
                    q.add(neighbor);
                }else if(neighbor != parent[curr]){
                    return true;
                }
            }
        }
        
        return false;
    }
    

    // DFS Method to detect cycle in Graph
    // TC - O(E)
    public static boolean isCycleDFS(int src, int parent, ArrayList<Integer>[] adj, boolean[] visited){
        visited[src] = true;
        
        for(Integer neighbor: adj[src]){
            if(!visited[neighbor]){
                if(isCycleDFS(neighbor, src, adj, visited)) return true;
            }else if(neighbor != parent){
                return true;
            }
        }
        
        return false;
    }
    
}

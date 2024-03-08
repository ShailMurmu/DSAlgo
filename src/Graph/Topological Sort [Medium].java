package Graph;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class TopoSort_Solution
{

    // BFS solution to find topological sorting in a graph
    public static ArrayList<Integer> topologicalSort1(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        ArrayList<Integer>[] adj = new ArrayList[v];
        for(int i=0; i<v; i++) adj[i] = new ArrayList<Integer>();
        
        for(ArrayList<Integer> edge: edges){
            adj[edge.get(0)].add(edge.get(1));
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        topoSortBFS(v, adj, ans);
        return ans; 
    }

    public static void topoSortBFS(int n, ArrayList<Integer>[] adj, ArrayList<Integer> ans){
        // Kahn's Algorithm
        // count the indegrees of vertices
        int[] indeg = new int[n];
        for(int i=0; i<n; i++){
            for(Integer v: adj[i]) indeg[v]++;
        }
        
        // put all the 0-degree vertex in queue
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<n; i++) if(indeg[i] == 0) q.add(i);
        
        //do BFS call
        while(!q.isEmpty()){
            Integer front = q.poll();
            ans.add(front);
            
            for(Integer neighbour: adj[front]){
                indeg[neighbour]--;
                if(indeg[neighbour] == 0) q.add(neighbour);
            }
        }
    }



    // DFS solution to find topological sorting in a graph
    // Time Complexity - O(E + V)
    public static ArrayList<Integer> topologicalSort2(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        ArrayList<Integer>[] adj = new ArrayList[v];
        for(int i=0; i<v; i++) adj[i] = new ArrayList<Integer>();
        
        for(ArrayList<Integer> edge: edges){
            adj[edge.get(0)].add(edge.get(1));
        }
        
        // call the connected components of the graph for all the vertices
        boolean[] visited = new boolean[v];
        Stack<Integer> stck = new Stack<Integer>();
        for(int i=0; i<v; i++){
            if(!visited[i])
                topoSortDFS(i, adj, visited, stck);
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!stck.isEmpty()){
            ans.add(stck.pop());
        }
        
        return ans;
    }
    
    public static void topoSortDFS(int node, ArrayList<Integer>[] adj, boolean[] visited, Stack<Integer> stck){
        visited[node] = true;
        
        for(Integer neighbour: adj[node]){
            if(!visited[neighbour])
                topoSortDFS(neighbour, adj, visited, stck);
        }
        
        stck.add(node);
    }
    
}


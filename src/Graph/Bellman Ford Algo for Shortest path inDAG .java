package Graph;

import structures.Pair;
import java.util.ArrayList;
/* 
Bellman-Ford Algorithm - to Find
Shortest paths from src to all vertices in the given graph. The graph may contain negative weight edges. 

Time Complexity - O(VE)
*/

class BellmanFord {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Pair>[] adj = new ArrayList[n];
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        // Edges
        adj[0].add(new Pair(1, 4));
        adj[1].add(new Pair(2, -2));
        adj[2].add(new Pair(3, 1));
        adj[3].add(new Pair(1, -1));

        int src = 0;
        dist[src] = 0;

        //1. Loop (n-1) time for all edges and update dist accordingly
        for(int t=0; t<n-1; t++){
            for(int i=0; i<n; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int u = i;
                    int v = adj[i].get(j).key;
                    int wt = adj[i].get(j).val;

                    if (dist[u] != Integer.MAX_VALUE && (dist[u] + wt < dist[v])) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        
        //2. Loop 1 more time for all edges
        // Check if any of dist gets updated
        // i. YES - Negative Cycle present ( It will keep on decreasing the distance)
        // ii. NO - No Negative Cycle present - Shortest path present in dist
        boolean flag = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<adj[i].size(); j++){
                int u = i;
                int v = adj[i].get(j).key;
                int wt = adj[i].get(j).val;

                if(dist[u] != Integer.MAX_VALUE && (dist[u] + wt < dist[v])){
                    flag = true;
                }
            }
        }

        if(flag) System.out.println("Negative Cycle Present");
        else{
            for(int i=0; i<n; i++) System.out.print(dist[i] + " ");
        }
    }
}

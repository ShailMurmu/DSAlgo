package Graph;

import structures.Pair;
import structures.Graph;

// Bridges in Graph are the edges which upon its removal increase the component of the graph

class FindBridges {
    static int timer;
    public static void main(String[] args){
        // Create Adj list of the graph
        Graph g = new Graph(3);
        g.addEdge(0,1,0);
        g.addEdge(1,2,0);

        g.dispGraph();

        // Initialise the required data structures (timer, dics, low, visited)
        // dics - First Discovery time
        // low - Lowest discovery time of the connected component (Possible Separate Component)
        timer = 0;
        int parent = -1;
        int[] disc = new int[g.cap];
        int[] low = new int[g.cap];
        boolean[] visited = new boolean[g.cap];
        for(int i=0; i<g.cap; i++){
            disc[i] = -1;
            low[i] = -1;
            visited[i] = false;
        }

        // Call the dfs for all the node
        for(int i=0; i<g.cap; i++){
            if(!visited[i]){
                dfs(i, parent, timer, g, disc, low, visited);
            }
        }
    }

    public static void dfs(int node, int parent, int timer, Graph g, int[] disc, int[] low, boolean[] vis){
        vis[node] = true;
        disc[node] = low[node] = timer++;

        // Process the neighbors
        for(Pair nbr: g.adj[node]){
            if(nbr.key == parent) continue;
            if(!vis[nbr.key]){
                dfs(nbr.key, node, timer, g, disc, low, vis);
                // Update the low of [current] node with low of [neighbour] node if min
                low[node] = Math.min(low[node], low[nbr.key]);

                //Check if this edge is Bridge.
                if(low[nbr.key] > disc[node]){
                    System.out.println(node+"----"+nbr.key);
                }
            }else{
                // Back edge
                // Update the low of [current] node with dics of [neighbour] node if min
                low[node] = Math.min(low[node], disc[nbr.key]);
            }
        }
    }
}

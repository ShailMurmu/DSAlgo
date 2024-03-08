package Graph;

import structures.Pair;
import structures.Graph;

// Articulation Point in a Graph is the node which upon its removal increase the component of the graph

class FindArticulationPoint {
    static  int timer;
    public static void main(String[] args) {
        // Create Adj list of the graph
        Graph g = new Graph(6);

        g.addEdge(0,1,0);
        g.addEdge(1,2,0);
        g.addEdge(0,2, 0);
        g.addEdge(0,3,0);
        g.addEdge(3,4,0);
        g.addEdge(4,5,0);
        g.addEdge(3,5,0);

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
                dfs(i, parent, g, disc, low, visited);
            }
        }

    }

    public static void dfs(int node, int parent, Graph g, int[] disc, int[] low, boolean[] visited){
        visited[node] = true;
        disc[node] = low[node] = timer++;

        int child = 0;
        // Process the neighbors
        for(Pair nbr: g.adj[node]){
            if(nbr.key == parent) continue;
            if(!visited[nbr.key]){
                dfs(nbr.key, node, g, disc, low, visited);
                // Update the low of [current] node with low of [neighbour] node if min
                low[node] = Math.min(low[node], low[nbr.key]);
                //Check if this node is an articulation point
                if(low[nbr.key] >= disc[node] && parent != -1){
                    System.out.println(node);
                }
                child++;
            }else{
                // Back edge
                // Update the low of [current] node with dics of [neighbour] node if min
                low[node] = Math.min(low[node], disc[nbr.key]);
            }
        }

        // if its the 1st node and its child is more than 1
        if(parent == -1 && child > 1){
            System.out.println(node);
        }
    }
}


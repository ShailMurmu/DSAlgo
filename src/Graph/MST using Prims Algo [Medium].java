package Graph;

import structures.Pair;
import structures.Graph;

class MST {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        // Build Adjacency List
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 8);
        g.addEdge(1, 2, 9);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 6);

        g.dispGraph();

        int[] key = new int[g.cap];
        boolean[] mst = new boolean[g.cap];
        int[] parent = new int[g.cap];

        // Initialise all the data structures
        for(int i=0; i<g.cap; i++){
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }

        // Mark Starting vertex
        int src = 0;
        key[src] = 0;
        parent[src] = -1;

        // Run for all the Vertices of the graph
        for(int i=0; i<g.cap; i++){
            int minWeight = Integer.MAX_VALUE;
            int u = i;

            // Find minimum of key which is not a part of mst
            // We can IMPROVE this step by using priority queue to get min key in O(1)
            // 
            for(int j=0; j<g.cap; j++){
                if(!mst[j] && key[j] < minWeight){
                  minWeight = key[j];
                  u = j;
                }
            }

            // mark the min vertex as part of mst
            mst[u] = true;

            // update the key and parent for all the adj node of current node
            // If Priority Queue is used then finding key will take log(n)
            for(Pair p: g.adj[u]){
                if(!mst[p.key] && p.val < key[p.key]){
                    key[p.key] = p.val;
                    parent[p.key] = u;
                }
            }
        }

        // Print the MST
        for(int i=0; i<g.cap; i++){
            System.out.print(parent[i] + " ");
        }
    }
}

/*
 * 
 * MST in UDG using Prim's Algorithm
 * Time Complexity: O(E + VlogV)
 * Space Complexity: O(E + V)
 * 
 */

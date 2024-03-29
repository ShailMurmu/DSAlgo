import sorting.MergeSort;
import sorting.QuickSort;
import structures.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[] {7,3,1,5,7,8,1,9,4};
        int[] arr2 = new int[] {7,3,1,5,7,8,1,9,4};

        MergeSort.mergeSort(arr1, 0, arr1.length-1);
        Arrays.stream(arr1).forEach(e -> System.out.print(e+" "));
        System.out.println();
        QuickSort.quickSort(arr2, 0, arr2.length-1);
        Arrays.stream(arr2).forEach(e -> System.out.print(e+" "));
    }

    public void runGraph() {
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
            for(int j=0; j<g.cap; j++){
                if(!mst[j] && key[j] < minWeight){
                    minWeight = key[j];
                    u = j;
                }
            }

            // mark the min vertex as part of mst
            mst[u] = true;

            // update the key and parent for all the adj node of current node
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
package structures;

import java.util.ArrayList;

public class Graph {
    public int cap;
    public ArrayList<Pair>[] adj;

    public Graph(int cap) {
        this.cap = cap;
        this.adj = new ArrayList[cap];

        for (int i = 0; i < cap; i++) {
            this.adj[i] = new ArrayList<Pair>();
        }
    }

    public void addEdge(int u, int v, int w){
        adj[u].add(new Pair(v, w));
        adj[v].add(new Pair(u, w));
    }

    public void dispGraph(){
        for(int i=0; i<cap; i++){
            System.out.print("("+i+") -> ");
            for(Pair p: adj[i]){
                System.out.print("("+p.key+", "+p.val+") ");
            }
            System.out.println();
        }
    }
}

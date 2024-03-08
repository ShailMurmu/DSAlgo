package Graph;
import structures.Pair;
import java.util.ArrayList;

class Pair2{
    public int num1;
    public Pair p1;

    public Pair2(int num1, Pair p1) {
        this.num1 = num1;
        this.p1 = p1;
    }
}

class Kruskal_Algo {
    public static void main(String[] args){
        // For Kruskal's Algorithm
        // Time Complexity - O(ElogE)
        //1. Linear Data Structure required to store edges with weights
        ArrayList< Pair2 > edges = new ArrayList<>();
        edges.add(new Pair2(5, new Pair(0, 1)));
        edges.add(new Pair2(8, new Pair(0, 2)));
        edges.add(new Pair2(9, new Pair(1, 2)));
        edges.add(new Pair2(2, new Pair(1, 3)));
        edges.add(new Pair2(6, new Pair(2, 3)));

        //2. sort the edges according to their weights
        edges.sort((a,b) -> Integer.compare(a.num1, b.num1));

        //3. Create parent and rank array for findParent and unionSet
        int[] parent = new int[4];
        int[] rank = new int[4];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        //4. For every edge, find parent of connecting node
        // If their parent are not equal, it means they are not connected with each other
        // Now connect them together
        int minWeight = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<edges.size(); i++){
            Pair2 p2 = edges.get(i);

            int u = findParent(parent, p2.p1.key);
            int v = findParent(parent, p2.p1.val);

            if(u != v){
                minWeight += p2.num1;
                sb.append("(").append(p2.p1.key).append(", ").append(p2.p1.val).append(") ");
                parent[u] = v;
            }
        }

        System.out.println(sb.toString());
    }


    // Recursive call with Path Compression
    public static int findParent(int[] parent, int node){
        if(parent[node] == node) return node;

        return parent[node] = findParent(parent, parent[node]);
    }

    // Union 2 disjoint set
    public static void unionSet(int u, int v, int[] parent, int[] rank){
        u = findParent(parent, u);
        v = findParent(parent, v);

        if(rank[u] < rank[v]){
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        }else{
            parent[u] = v;
            rank[v]++;
        }
    }
}


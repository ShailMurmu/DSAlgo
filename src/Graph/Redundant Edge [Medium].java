package Graph;

class RedundantEdge_Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        
        // Bridges in Graph are the edges which upon its removal increase the component of the graph
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        
        for(int i=1; i<=edges.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        int[] res = new int[2];
        for(int i=0; i<edges.length; i++){
            if(!unionNode(edges[i][0], edges[i][1]))
            {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
                return res;
            }
        }
        
        return res;
        
    }
    
    public int findParent(int node){
        if(parent[node] == node) return node;
        
        return parent[node] = findParent(parent[node]);
    }
    
    public boolean unionNode(int node1, int node2){
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        
        if(parent1 == parent2) return false;
        
        if(rank[parent1] < rank[parent2]){
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
            return true;
        }else if(rank[parent2] < rank[parent1]){
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
            return true;
        }else{
            parent[parent2] = parent1;
            rank[parent1] += 1;
            return true;
        }
    }
}

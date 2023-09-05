class Solution {
    public int find(int x, int[] parent){
            if(parent[x] == -1) return x;
            return parent[x] = find(parent[x], parent);
        }

    public boolean union(int x, int y, int[] parent){
            int parent_x = find(x, parent);
            int parent_y = find(y, parent);
            if(parent_x == parent_y) return true;
            parent[parent_x] = parent_y;
            return false;
        }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent);
        }

        return find(source, parent) == find(destination, parent);

        // we can solve using dfs and bfs also.
    }
}
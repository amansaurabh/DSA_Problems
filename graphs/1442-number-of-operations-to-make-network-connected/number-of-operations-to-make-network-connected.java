class Solution {
    private int find(int i , int[] parent){
        if(i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }

    private void union(int x, int y, int[] parent, int[] rank){
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent] += 1;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;

        if(edges < n - 1){
            return -1;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int elaka = n;

        for(int[] arr : connections){
            int first = find(arr[0], parent);
            int second = find(arr[1], parent);

            if(first == second){
                continue;
            }
            elaka -= 1;
            union(first, second, parent, rank);
            
        }
        return elaka - 1;
    }
}
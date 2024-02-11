class Solution {
    private int find(int i , int[] parent){
        if(i == parent[i]){
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    private void union(int x, int y, int[] parent, int[] rank){
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent] += 1;
        }
    }

    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int[] arr : edges){
            int first = arr[0];
            int second = arr[1];

            union(first, second, parent, rank);
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < n; i++){
            int papaji = find(i, parent);

            freq.put(papaji, freq.getOrDefault(papaji, 0) + 1);
        }
        
        long result = 0;
        long remainingNodes = n;

        for(int value : freq.values()){
            result += (long)(value) * (remainingNodes - value);
            remainingNodes -= value;
        }

        return result;
    }
}
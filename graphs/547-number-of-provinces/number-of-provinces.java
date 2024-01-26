class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(isConnected, i, vis, n);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int u, boolean[] vis, int n){
        vis[u] = true;

        for(int v = 0; v < n; v++){
            if(!vis[v] && isConnected[u][v] == 1){
                dfs(isConnected, v, vis, n);
            }
        }
    }
}
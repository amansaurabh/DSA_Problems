class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];

        int group = 0;
        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
        
        dfs(stones, i, vis);
        group++;
        }
        return n - group;
    }
    public void dfs(int[][] stones, int u, boolean[] vis){
        vis[u] = true;
        for(int i = 0; i < stones.length; i++){
            int r = stones[u][0];
            int c = stones[u][1];
        if(!vis[i] && (stones[i][0] == r || stones[i][1] == c)){
            dfs(stones, i, vis);
        }
    }
}
}
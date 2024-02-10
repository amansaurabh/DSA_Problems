class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                bfs(isConnected, i, vis, n);
                count++;
            }
        }
        return count;
    }

    private void bfs(int[][] isConnected, int u, boolean[] vis, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        vis[u] = true;

        while(!q.isEmpty()){
            q.poll();
            for(int v = 0; v < n; v++){
                if(!vis[v] && isConnected[u][v] == 1){
                    bfs(isConnected, v, vis, n);
                }
            }
        }
    }
}
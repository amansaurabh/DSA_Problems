class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(rooms, 0, vis);
        for(int i = 0; i < n; i++){
             if (!vis[i]) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int u, boolean[] vis){
        vis[u] = true;
        for(int key : rooms.get(u)){
            if(!vis[key]){
                dfs(rooms, key, vis);
            }
        }
    }
}
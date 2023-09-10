class Solution {

    private int dfs(List<List<Integer>> adj, int curr, int parent, List<Boolean> hasApple){
        int time = 0;
        for(int child : adj.get(curr)){
            if(child == parent) continue;
            int timeFromChild = dfs(adj, child, curr, hasApple);
            if(timeFromChild > 0 || hasApple.get(child) == true){
                time += timeFromChild + 2;
            }
        }
        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i= 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int totalTime = dfs(adj, 0, -1, hasApple);
        return totalTime;
    }
}
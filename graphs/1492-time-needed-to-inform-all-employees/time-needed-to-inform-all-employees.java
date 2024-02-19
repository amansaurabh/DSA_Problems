class Solution {
    int maxTime = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n == 1){
            return 0;
        }
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n ; i++){
            if(manager[i] != -1){
                adj.get(manager[i]).add(i);
            }
        }
        dfs(adj, headID, informTime, 0);
        return maxTime;
    }

    private void dfs(List<List<Integer>> adj, int currEmp, int[] informTime, int curr_time){
        maxTime = Math.max(maxTime, curr_time);
        
        for(int subOrdinate : adj.get(currEmp)){
           dfs(adj, subOrdinate, informTime, curr_time + informTime[currEmp]);
        }
    }
}
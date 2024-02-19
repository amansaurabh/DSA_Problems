class Solution {
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

        return dfs(adj, headID, informTime);
    }

    private int dfs(List<List<Integer>> adj, int currEmp, int[] informTime){
        int maxTime = 0;

        for(int subOrdinate : adj.get(currEmp)){
            maxTime = Math.max(maxTime, dfs(adj, subOrdinate, informTime));
        }
        return maxTime + informTime[currEmp];
    }
}
class Solution {
    private void dfs(int[][] graph, int u, List<List<Integer>> result, List<Integer> path){
        path.add(u);
        if(u == graph.length - 1){
            result.add(new ArrayList<>(path));
        }else{
            for(int v : graph[u]){
                dfs(graph, v, result, path);
            }
        }
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, result, path);
        return result;
    }
}
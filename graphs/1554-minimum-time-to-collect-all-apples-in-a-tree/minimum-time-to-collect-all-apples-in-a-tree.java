class Solution {

   private int dfs(int node, List<List<Integer>> graph, List<Boolean> hasApple, Set<Integer> visited) {
        visited.add(node);
        int totalTime = 0;

        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                int subTreeTime = dfs(neighbor, graph, hasApple, visited);
                if (subTreeTime > 0 || hasApple.get(neighbor)) {
                    totalTime += subTreeTime + 2;
                }
            }
        }

        return totalTime;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i= 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(0, graph, hasApple, visited);
    }
}
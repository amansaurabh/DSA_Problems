class Solution {

    private List<Integer> dfs(int node, String labels, List<List<Integer>> graph, int[] result, boolean[] visited) {
        visited[node] = true;
        List<Integer> counts = new ArrayList<>(Collections.nCopies(26, 0));
        counts.set(labels.charAt(node) - 'a', 1);

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                List<Integer> childCounts = dfs(child, labels, graph, result, visited);

                for (int i = 0; i < 26; i++) {
                    counts.set(i, counts.get(i) + childCounts.get(i));
                }
            }
        }

        result[node] = counts.get(labels.charAt(node) - 'a');
        return counts;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
         List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        dfs(0, labels, graph, result, visited);

        return result;
    }
}
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Not pass all the test cases

        // int n = graph.length;
        // int[] terminal = new int[n];
        // List<Integer> ans = new ArrayList<>();

        // for(int i = 0; i < n; i++){
        //     if(graph[i].length == 0){
        //         terminal[i] = 1;
        //     }
        // }
        
        // for(int i = 0; i < n; i++){
        //     int[] curr = graph[i];
        //     int count = 0;
        //     for(int x : curr){
        //         if(terminal[x] == 1){
        //             count++;
        //         }
        //     }
        //     if(count == curr.length){
        //         ans.add(i);
        //     }
        // }
        // return ans;

        // Correct Approach : Using DFS

        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] inRecursion = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(graph, i, visited, inRecursion);
            }
        }
        for(int i = 0; i < n; i++){
            if(!inRecursion[i])
                ans.add(i);
        }
        return ans;
    }
    private boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] inRecursion) {

        visited[node] = true;
        inRecursion[node] = true;

        for(int neighbour : graph[node]){
            if(visited[neighbour] == false && dfs(graph, neighbour, visited, inRecursion))
                return true;
            else if(inRecursion[neighbour] == true)
                return true;
        }
        inRecursion[node] = false;
        return false;
    }
}
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
        boolean[] safe = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(dfs(graph, i, visited, safe)){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] safe) {
        if(visited[node]){
            return safe[node];
        }

        visited[node] = true;
        for(int neighbour : graph[node]){
            if(!dfs(graph, neighbour, visited, safe)){
                return false;
            }
        }
        safe[node] = true;
        return true;
    }
}
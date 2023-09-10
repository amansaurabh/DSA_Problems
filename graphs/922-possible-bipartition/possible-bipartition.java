class Solution {

    public boolean dfs(List<List<Integer>> adj, int u, int[] color, int curCol){
        color[u] = curCol;
        for(int v : adj.get(u)){
            if(color[v] == curCol) return false;
            if(color[v] == 0){
                if(!dfs(adj, v, color, -curCol)) return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] dislike : dislikes){
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]);
        }

        int[] color = new int[n+1];
        for(int i = 0; i <= n; i++){
            if(color[i] == 0){
                if(!dfs(adj, i, color, -1)) return false;
            }
        }
        return true;
    }
}
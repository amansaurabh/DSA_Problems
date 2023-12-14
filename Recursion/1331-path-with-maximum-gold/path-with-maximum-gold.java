class Solution {
    private int travelAndCollect(int[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int currentGold = grid[i][j];

        int up = travelAndCollect(grid, i - 1, j, visited); // Up
        int down = travelAndCollect(grid, i + 1, j, visited); // Down
        int left = travelAndCollect(grid, i, j - 1, visited); // Left
        int right = travelAndCollect(grid, i, j + 1, visited); // Right
        
        visited[i][j] = false;
        return currentGold + Math.max(Math.max(up, down), Math.max(left, right));
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    max = Math.max(max, travelAndCollect(grid, i, j, visited));
                
                }
            }
        }    
        return max;
    }
}
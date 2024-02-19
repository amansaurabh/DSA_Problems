class Solution {
    int m, n;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if(grid == null || m == 0 || n == 0){
            return 0;
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col){

        grid[row][col] = '0';

        for(int[] dir : dirs){
            int newX = row + dir[0];
            int newY = col + dir[1];

            if(newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == '1'){
                dfs(grid, newX, newY);
            }
        }
    }
}
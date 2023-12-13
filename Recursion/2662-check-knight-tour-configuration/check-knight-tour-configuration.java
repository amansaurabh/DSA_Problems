class Solution {
    public boolean checkValidGrid(int[][] grid) {
        // Check if the top-left cell is 0. If not, return false.
        if (grid[0][0] != 0) {
            return false;
        }
        
        // Calculate the total number of cells in the grid.
        int n = grid.length * grid.length;
        
        // Define the directions to move in the grid.
        int dirs[][] = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
        
        // Initialize the current position to (0, 0).
        int x = 0, y = 0;
        
        // Loop through all the cells in the grid.
        for (int i = 1; i < n; i++) {
            // Set a flag to indicate if a valid move was made.
            boolean flag = true;
            
            // Try each of the 8 possible moves in turn.
            for (int dir[] : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                // Check if the move is within the bounds of the grid and leads to the next number in sequence.
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid.length && grid[nx][ny] == i) {
                    x = nx;
                    y = ny;
                    flag = false;
                    break;
                }
            }
            
            // If no valid move was made, return false.
            if (flag) {
                return false;
            }
        }
        
        // If all cells were visited in sequence, return true.
        return true;
    }
}
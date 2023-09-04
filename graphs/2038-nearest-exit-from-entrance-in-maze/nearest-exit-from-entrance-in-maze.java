class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = '+';

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            if ((row != entrance[0] || col != entrance[1]) && (row == 0 || col == 0 || row == m - 1 || col == n - 1)) {
                return steps;
            }
            for(int dir[] : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                 if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.') {
                    q.offer(new int[]{newRow, newCol, steps + 1});
                    maze[newRow][newCol] = '+';
                }
            }
        }
        return -1;
    }
}
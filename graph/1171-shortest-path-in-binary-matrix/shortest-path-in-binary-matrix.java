class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = {{1, 1}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}};
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0 || n == 0 || grid[0][0] != 0){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        grid[0][0] = 1;

        int level = 0;

        while(!q.isEmpty()){
            int N = q.size();

            // for (int i = 0; i < N; i++) {
            while(N-- > 0){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                if(x == m - 1 && y == n - 1){
                    return level + 1;
                }
                for(int[] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0){
                        q.offer(new int[]{newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
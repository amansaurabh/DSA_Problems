class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Count fresh oranges and add rotten oranges to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshOranges++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();

                for (int[] dir : directions) {
                    int nextR = curr[0] + dir[0];
                    int nextC = curr[1] + dir[1];

                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols
                            && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2;
                        freshOranges--;
                        queue.offer(new int[]{nextR, nextC});
                    }
                }
            }

            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
}
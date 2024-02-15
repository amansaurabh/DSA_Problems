class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int dis = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                dist[x][y] = dis;
                for(int[] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >=0 && newX < m && newY >=0 && newY < n && !vis[newX][newY]){
                        q.offer(new int[]{newX, newY});
                        vis[newX][newY] = true;
                    }
                }
            }
            dis++;
        }
        return dist;
    }
}
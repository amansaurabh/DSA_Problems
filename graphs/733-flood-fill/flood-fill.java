class Solution {
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        dfs(image, sr, sc, color);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color){
        
        int startingColor = image[sr][sc];
        image[sr][sc] = color;

        for(int[] dir : dirs){
            int newX = sr + dir[0];
            int newY = sc + dir[1];
            if(newX >= 0 && newY >= 0 && newX < image.length && newY < image[0].length && image[newX][newY] == startingColor){
                dfs(image, newX, newY, color);
            }
        }
    }
}
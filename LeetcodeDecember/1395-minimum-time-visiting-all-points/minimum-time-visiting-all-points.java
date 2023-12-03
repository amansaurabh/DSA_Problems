class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        
        for (int i = 0; i < points.length - 1; i++) {
            int xDiff = Math.abs(points[i][0] - points[i + 1][0]);
            int yDiff = Math.abs(points[i][1] - points[i + 1][1]);
            
            // Calculate the diagonal movement time
            int diagonalTime = Math.min(xDiff, yDiff);
            
            // Calculate the remaining horizontal/vertical movement time
            int remainingTime = Math.abs(xDiff - yDiff);
            
            // Total time to move from one point to the next
            totalTime += diagonalTime + remainingTime;
        }
        
        return totalTime;
    }
}
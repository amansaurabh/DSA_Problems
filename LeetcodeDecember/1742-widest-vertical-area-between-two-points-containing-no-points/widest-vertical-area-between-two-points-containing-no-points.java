class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int res = 0;

        for(int i = 1; i < n; i++){
            int width = points[i][0] - points[i-1][0];
            res = Math.max(res, width);
        }
        return res;
    }
}
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int end = n - 1;
        int start = 0;
        int ans = 0;
        while(start < end){
            int width = end - start;
            int h = Math.min(height[start], height[end]);
            int area = width * h;
            ans = Math.max(area, ans);
            if(height[start] < height[end]) start++;
            else end--;
        }
        return ans;
    }
}
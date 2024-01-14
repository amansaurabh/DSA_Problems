class Solution {
    public int largestRectangleArea(int[] heights) {
        // int n = heights.length;
        // Stack<Integer> stack = new Stack<>();
        // int maxArea = 0;

        // for (int i = 0; i <= n; i++) {
        //     // For each bar, pop elements from the stack until a smaller bar is encountered
        //     while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
        //         int height = heights[stack.pop()];
        //         int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        //         maxArea = Math.max(maxArea, height * width);
        //     }

        //     // Push the current index onto the stack
        //     stack.push(i);
        // }

        // return maxArea;


        int n = heights.length;
        int maxArea = 0;
        int[] left = new int[n]; // Store the left boundary for each bar
        int[] right = new int[n]; // Store the right boundary for each bar

        // Calculate the left boundaries
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        // Calculate the right boundaries
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        // Calculate the maximum area
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * (width);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;     
    }
}
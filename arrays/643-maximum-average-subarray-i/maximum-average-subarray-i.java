class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Set the initial maxSum value
        maxSum = sum;

        // Calculate the sum of contiguous subarrays of length k
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Update sum by adding the next element and subtracting the first element

            // Update maxSum if the current sum is greater
            maxSum = Math.max(maxSum, sum);
        }

        // Calculate the maximum average value
        double maxAverage = (double) maxSum / k;
        return maxAverage;
    }
}
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int K) {
        int N = arr.length, dp[] = new int[K];
        for (int i = 1; i <= N; ++i) {
            int curMax = 0, best = 0;
            for (int k = 1; k <= K && i - k >= 0; ++k) {
                curMax = Math.max(curMax, arr[i - k]);
                best = Math.max(best, dp[(i - k) % K] + curMax * k);
            }
            dp[i % K] = best;
        }
        return dp[N % K];
    }
}
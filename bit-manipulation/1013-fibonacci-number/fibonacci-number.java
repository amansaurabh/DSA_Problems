class Solution {

    private int solve(int n, int[] dp){
        if (n <= 1){
            return n;
        }
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1, dp) + solve(n - 2, dp);
    }
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n+1];
        for(int i = 0; i <=n; i++ ){
            dp[i] = -1;
        }
       return solve(n, dp); 
    }
}
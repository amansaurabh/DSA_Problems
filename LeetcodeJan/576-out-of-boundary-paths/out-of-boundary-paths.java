class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int MOD = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                Arrays.fill(dp[i][j], - 1);
        int paths = dp(m, n, maxMove, startRow, startColumn, dp);
        return (paths % MOD);
    }
    
    public int dp(int m, int n, int maxMove, int cr, int cc, int[][][] dp){
        if(cr == m || cc == n || cr == -1 || cc == -1)
            return 1;
        
        if(maxMove==0)
            return 0;
        
        if(dp[cr][cc][maxMove] != -1){
            return dp[cr][cc][maxMove];
        }
        
        int paths = 0;
        
        for(int[] d : dir){
            int x = cr+d[0];
            int y = cc+d[1];
            paths += dp(m, n, maxMove-1, x, y, dp)  % MOD;
            paths %= MOD;
        }
        dp[cr][cc][maxMove] = paths ;
        return paths;
    }
}
class Solution {
    int t[][] = new int[301][11];
    private int solve (int[] jd, int n, int idx, int d){
        if(d==1){
            int maxD = jd[idx];
            for(int i = idx; i < n; i++){
                maxD = Math.max(maxD, jd[i]);
            }
            return maxD;
        }
        if(t[idx][d] != -1) return t[idx][d];

        int maxD = jd[idx];
        int finalRes = Integer.MAX_VALUE;

        for(int i = idx; i <= n - d; i++){
            maxD = Math.max(maxD, jd[i]);

            int result = maxD + solve(jd, n, i + 1, d - 1);

            finalRes = Math.min(finalRes, result);
        }
        t[idx][d] = finalRes; // Memoize the result
        return finalRes;
    } 
    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;

        if(n < d) return -1;

        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], -1);
        }
        
        return solve(jd, n, 0, d);
    }
}
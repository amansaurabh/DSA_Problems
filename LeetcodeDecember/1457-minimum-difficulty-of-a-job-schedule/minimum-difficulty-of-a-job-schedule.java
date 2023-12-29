class Solution {
    // int t[][] = new int[301][11];
    // private int solve (int[] jd, int n, int idx, int d){
    //     if(d==1){
    //         int maxD = jd[idx];
    //         for(int i = idx; i < n; i++){
    //             maxD = Math.max(maxD, jd[i]);
    //         }
    //         return maxD;
    //     }
    //     if(t[idx][d] != -1) return t[idx][d];

    //     int maxD = jd[idx];
    //     int finalRes = Integer.MAX_VALUE;

    //     for(int i = idx; i <= n - d; i++){
    //         maxD = Math.max(maxD, jd[i]);

    //         int result = maxD + solve(jd, n, i + 1, d - 1);

    //         finalRes = Math.min(finalRes, result);
    //     }
    //     t[idx][d] = finalRes; // Memoize the result
    //     return finalRes;
    // } 
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;

        Map<String, Integer> memo = new HashMap<>();
        int result = dfs(jobDifficulty, d, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[] jobDifficulty, int days, int index, Map<String, Integer> memo) {
        if (index == jobDifficulty.length && days == 0) return 0;
        if (index == jobDifficulty.length || days == 0) return Integer.MAX_VALUE;

        String key = index + "_" + days;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxDifficulty = jobDifficulty[index];
        int minDifficulty = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int i = index; i < jobDifficulty.length; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            int next = dfs(jobDifficulty, days - 1, i + 1, memo);
            if (next != Integer.MAX_VALUE) {
                result = Math.min(result, maxDifficulty + next);
            }
        }

        memo.put(key, result);
        return result;
    }
}
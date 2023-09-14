class Solution {
    
    private long solve(int idx, int[] nums, int flag, long[][] memo){
        if(idx >= nums.length){
            return 0;
        }
        if(memo[idx][flag] != -1) return memo[idx][flag];
        long skip = solve(idx+1, nums, flag, memo);
        long val = nums[idx];
        if(flag == 0){
            val = -val;
        }
        long take = val + solve(idx+1, nums, 1-flag, memo);
        return memo[idx][flag] = Math.max(skip, take);
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // Arrays.fill(memo, -1);
        long[][] memo = new long[n][2];
         for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, nums, 1, memo);
    }
}
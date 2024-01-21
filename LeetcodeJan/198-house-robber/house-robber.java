class Solution {
    // private int solve(int[] nums, int i, int n, int[] memo){
    //     if(i >= n)
    //     return 0;
    //     if(memo[i] != -1) return memo[i];
    //     int steal = nums[i] + solve(nums, i + 2, n, memo);
    //     int skip = solve(nums, i+1, n, memo);
    //     return memo[i] = Math.max(steal, skip);
    // }

    public int rob(int[] nums) {
        int n = nums.length;
        // int[] memo = new int[n + 1];
        // Arrays.fill(memo, -1);
        // return solve(nums, 0, n, memo);
        if(n == 1) return nums[0];
        // int[] t = new int[n+1];
        //t[i] -> means maximum stolen money till i house
        // i = 0 -> no house means no profit
        // t[0] = 0;
        int prevPrev = 0;
        // i = 1 -> one house means profit of house one
        // t[1] = nums[0];
        int prev = nums[0];
        for(int i = 2; i <= n; i++){
            // int steal = nums[i-1] + t[i - 2];
            int steal = nums[i-1] + prevPrev;
            // int skip = t[i -1]; 
            int skip = prev; 
            // t[i] = Math.max(steal, skip);
            int temp = Math.max(steal, skip);
            prevPrev = prev;
            prev = temp;

        }
        return prev;
    }
}
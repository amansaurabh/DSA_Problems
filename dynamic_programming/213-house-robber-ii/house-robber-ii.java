class Solution {
    
    //  private int solve(int[] nums, int i, int n, int[] memo){
    //     if(i > n)
    //     return 0;
    //     if(memo[i] != -1) return memo[i];
    //     int steal = nums[i] + solve(nums, i + 2, n, memo);
    //     int skip = solve(nums, i+1, n, memo);
    //     return memo[i] = Math.max(steal, skip);
    // }
    public int rob(int[] nums) {
        int n = nums.length;

        // if (n == 1) {
        //     return nums[0];
        // }
        // if (n == 2){
        //     return Math.max(nums[0], nums[1]);
        // }
        // int[] memo = new int[n+1];
        // Arrays.fill(memo, -1);
        // int take_0th_house = solve(nums, 0, n - 2, memo);
        // Arrays.fill(memo, -1);
        // int take_1st_house = solve(nums, 1, n - 1, memo);
        // return Math.max(take_0th_house, take_1st_house);

        int[] t = new int[n+1];
        if (n == 1) {
            return nums[0];
        }
        t[0] = 0;
        //case1: take the first house && skip the last house
        for(int i = 1; i <= n-1; i++){
            int steal = nums[i-1] + ((i-2 >= 0) ? t[i-2] : 0);
            int skip = t[i-1];
            t[i] = Math.max(steal, skip);
        }
        int res1 = t[n-1];

        //case1: skip the first house &&  can take the last house
        t[0] = 0;
        t[1] = 0;
        for(int i = 2; i <= n; i++){
            int steal = nums[i-1] + t[i-2];
            int skip = t[i-1];
            t[i] = Math.max(steal, skip);
        }
        int res2 = t[n];

        return Math.max(res1, res2);
    }
}
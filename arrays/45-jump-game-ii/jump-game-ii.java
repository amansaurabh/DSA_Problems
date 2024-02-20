class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return 0;
        }
        int totalJumps = 0;
        int destination = n - 1;

        int coverage = 0, lastJump = 0;

        for(int i = 0; i < n; i++){
            coverage = Math.max(coverage, i + nums[i]);
            if(i == lastJump){
                lastJump = coverage;
                totalJumps++;
            }

            if(lastJump >= n - 1){
                return totalJumps;
            }
        }
        return totalJumps;
    }
}
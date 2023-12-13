class Solution {
    int counter;
    public int findTargetSumWays(int[] nums, int target) {
      counter = 0;
        TargetSum(nums, target, 0, 0);
        return counter;
            
        }

    public void TargetSum(int[] nums, int target, int ind, int val) {
        if(ind == nums.length){
            if(target == val){
                counter++;
            }
        return;
        }
        
        TargetSum(nums, target, ind + 1, val + nums[ind]);
        TargetSum(nums, target, ind + 1, val - nums[ind]);
    }
}
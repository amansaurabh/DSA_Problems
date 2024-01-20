class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        
        if(n == 3){
            return nums[0] + nums[1] + nums[2];
        }
        int firstMin = nums[0];
        
        Arrays.sort(nums, 1, n);
        return firstMin + nums[1] + nums[2];
    }
}
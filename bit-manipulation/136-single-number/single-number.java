class Solution {
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++){
            xor ^= nums[i];
        }
        return xor;
    }
}
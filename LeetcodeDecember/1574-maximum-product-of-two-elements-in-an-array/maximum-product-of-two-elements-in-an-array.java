class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int ans = 0;
        for(int i = 1; i < nums.length; i++){
            int product = (max - 1) * (nums[i] - 1); 
            if(ans < product){
                ans = product;
            }
            if(max < nums[i]){
                max = nums[i];
            }
            
        }
        return ans;
    }
}
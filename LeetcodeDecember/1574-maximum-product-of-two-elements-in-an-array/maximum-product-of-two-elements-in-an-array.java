class Solution {
    public int maxProduct(int[] nums) {

        //-----------------Approach 1: --------------------------

        // int max = nums[0];
        // int ans = 0;
        // for(int i = 1; i < nums.length; i++){
        //     int product = (max - 1) * (nums[i] - 1); 
        //     if(ans < product){
        //         ans = product;
        //     }
        //     if(max < nums[i]){
        //         max = nums[i];
        //     }
            
        // }
        // return ans;

        //-----------------Approach 2: --------------------------

        int largest = 0;
        int sec_largest = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > largest){
                sec_largest = largest;
                largest = nums[i];
            }
            else{
                sec_largest = Math.max(sec_largest, nums[i]);
            }
        }
        return (sec_largest- 1) * (largest - 1);
    }
}
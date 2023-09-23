class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
       for(int i : nums){
           sum += i;
       }
       int cs = 0;
       for(int i = 0; i < n; i++){
           int ls = cs;
           int rs = sum - ls - nums[i];
           if(ls == rs){
               return i;
           }
           cs += nums[i];
       }
       return -1;
    }
}
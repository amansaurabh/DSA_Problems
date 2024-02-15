class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;

        for(int n : nums){
            if(j < 2 || n > nums[j - 2]){
                nums[j++] = n;
            }
        }
        return j; 
    }
}
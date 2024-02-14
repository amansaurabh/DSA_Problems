class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int idx = 0;
        int pos = 1;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                res[idx] = nums[i];
                idx += 2;
            }else{
                res[pos] = nums[i];
                pos += 2;
            }
        }
        return res;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        // int xor = nums[0];
        // int n = nums.length;
        // for(int i = 1; i < n; i++){
        //     xor ^= nums[i];
        // }
        // return xor;

        // other way
        int n = nums.length; // extracting the size of the array
        
        // traverse from the array
        for(int i = 0; i < n - 1; i++)
        {
            nums[i + 1] = nums[i] ^ nums[i + 1]; // (prev answer xor current index)
        }
        
        return nums[n- 1]; // return left over element
    }
}
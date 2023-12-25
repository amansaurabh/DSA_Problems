class Solution {
    public void moveZeroes(int[] nums) {
        // int left = 0; // Left pointer to track non-zero elements

        // // Iterate through the array
        // for (int right = 0; right < nums.length; right++) {
        //     // If the current element is non-zero, swap it with the left pointer element
        //     if (nums[right] != 0) {
        //         int temp = nums[left];
        //         nums[left] = nums[right];
        //         nums[right] = temp;
        //         left++; // Move the left pointer to the next position
        //     }
        // }

        if (nums.length == 1) {
            return;
        }

        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

       
         while(nonZeroIndex<nums.length){
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Variable to track the number of elements not equal to val

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to val, move it to the front of the array
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
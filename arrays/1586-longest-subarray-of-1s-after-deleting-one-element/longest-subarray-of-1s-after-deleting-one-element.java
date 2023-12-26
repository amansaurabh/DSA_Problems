class Solution {
    public int longestSubarray(int[] nums) {
        int prev = 0; int curr = 0;
        int ans = 0;
        for(int i: nums){
            if(i==1) curr++;
            else{
                ans = Math.max(ans,curr+prev);
                prev = curr;
                curr = 0;
            }
        }
        ans = Math.max(ans, curr+prev);
        
        return ans==nums.length?ans-1:ans;

        // int n = nums.length; // The size of the input array

        // int left = 0; // The left pointer of the sliding window
        // int zeros = 0; // Number of zeroes encountered
        // int ans = 0; // Maximum length of the subarray

        // for (int right = 0; right < n; right++) {
        //     if (nums[right] == 0) {
        //         zeros++; // Increment the count of zeroes
        //     }

        //     // Adjust the window to maintain at most one zero in the subarray
        //     while (zeros > 1) {
        //         if (nums[left] == 0) {
        //             zeros--; // Decrement the count of zeroes
        //         }
        //         left++; // Move the left pointer to the right
        //     }

        //     // Calculate the length of the current subarray and update the maximum length
        //     ans = Math.max(ans, right - left + 1 - zeros);
        // }

        // // If the entire array is the subarray, return the size minus one; otherwise, return the maximum length
        // return (ans == n) ? ans - 1 : ans;
    }
}
class Solution {
    public int missingNumber(int[] nums) {
        // Appraoch 1 : TC: O(n) SC O(n)

        /*
        int n = nums.length;
        int[] freq = new int[n + 1];
        for(int num : nums){
            freq[num]++;
        }

        for(int i = 0; i <= n; i++){
            if(freq[i] == 0){
                return i;
            }
        }
        return -1;
        */

        // Approach 2:

        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2;

        for(int num : nums){
            totalSum -= num;
        }
        return totalSum;
    }
}
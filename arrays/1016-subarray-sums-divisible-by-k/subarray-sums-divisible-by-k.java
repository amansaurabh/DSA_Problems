class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        // Brute Force O(n2)

        // int n = nums.length;
        // int count = 0;
        // for(int i = 0; i < n; i++){
        //     int sum = 0;
        //     for(int j = i; j < n; j++){
        //         sum += nums[j];
        //         if(Math.abs(sum) % k == 0){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        int n = nums.length;
        int count = 0;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;

        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int[] remainderCount = new int[k];
        remainderCount[0] = 1;

        for(int i = 1; i <= n; i++){
            int remainder = (prefixSum[i] % k + k) % k; // Ensure positive remainder
            count += remainderCount[remainder];
            remainderCount[remainder]++;
        }
        return count;
    }
}
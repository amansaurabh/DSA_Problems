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


        // int n = nums.length;
        // int count = 0;
        // int[] prefixSum = new int[n + 1];
        // prefixSum[0] = 0;

        // for(int i = 1; i <= n; i++){
        //     prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        // }

        // int[] remainderCount = new int[k];
        // remainderCount[0] = 1;

        // for(int i = 1; i <= n; i++){
        //     int remainder = (prefixSum[i] % k + k) % k; // Ensure positive remainder
        //     count += remainderCount[remainder];
        //     remainderCount[remainder]++;
        // }
        // return count;


        // Using Map

        // int n = nums.length;
        // //{remainder, times}
        // Map<Integer, Integer> map = new HashMap<>();
        // int sum = 0;
        // map.put(0, 1);

        // int result = 0;

        // for(int i = 0; i < n; i++){
        //     sum += nums[i];

        //     int rem = sum % k;

        //     if(rem < 0) rem += k;

        //     if(map.containsKey(rem)){
        //         result += map.get(rem);
        //     }

        //     map.put(rem, map.getOrDefault(rem, 0) + 1);
        // }
        // return result;

        // Using Array

        int[] map = new int[k];
        int result = 0;
        int sum = 0;
        map[0] = 1;

        for(int num : nums){
            sum += num;

            int rem = sum % k;

            if(rem < 0) rem += k;

            result += map[rem];

            map[rem]++;
        }
        return result;
    }
}
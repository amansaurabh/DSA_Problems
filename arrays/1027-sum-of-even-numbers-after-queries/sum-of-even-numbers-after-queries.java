class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        int evenSum = 0;
        for(int num : nums){
            if(num % 2 == 0){
                evenSum += num;
            }
        }
        
        for(int i = 0; i < n; i++){
            int val = queries[i][0];
            int idx = queries[i][1];
            int oldValue = nums[idx];
            
            if(oldValue % 2 == 0){
                evenSum -= oldValue;
            }

            nums[idx] += val;

            if(nums[idx] % 2 == 0){
                evenSum += nums[idx];
            }
            result[i] = evenSum;
        }
        return result;
    }
}
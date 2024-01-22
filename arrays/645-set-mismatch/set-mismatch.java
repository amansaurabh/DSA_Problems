class Solution {
    public int[] findErrorNums(int[] nums) {
        // int n =  nums.length;

        // int dup = -1;
        // int missing = -1;

        // for(int i = 0; i < n; i++){
        //     int num = Math.abs(nums[i]);

        //     if(nums[num - 1] < 0){
        //         dup = num;
        //     }else{
        //         nums[num - 1] *= (-1);
        //     }
        // }
        // for(int i = 0; i < n; i++){
        //     if(nums[i] > 0){
        //         missing = (i + 1);
        //         break;
        //     }
        // }
        // return new int[]{dup, missing};

        int N = nums.length, sum = N * (N + 1) / 2;
        int[] result = new int[2];
        boolean[] seen = new boolean[N+1];
        for (int num : nums) {
            sum -= num;
            if (seen[num]) result[0] = num;
            seen[num] = true;
        }
        result[1] = sum + result[0];
        return result;
        
    }
}
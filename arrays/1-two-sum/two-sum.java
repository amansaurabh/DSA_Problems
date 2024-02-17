class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Approach 1 : BRUTE FORCE O(n^2)
        // int n = nums.length;
        // int[] res = new int[2];

        // for(int i = 0; i < n; i++){
        //     for(int j = i + 1; j < n; j++){
        //         if(nums[i] + nums[j] == target){
        //             res[0] = i;
        //             res[1] = j;
        //             return res;
        //         }
        //     }
        // }
        // return new int[0];

        // Approach 2 :

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int reqNum = target - nums[i];
            if(indexMap.containsKey(reqNum)){
                int[] res = {indexMap.get(reqNum), i};
                return res;
            }
            indexMap.put(nums[i], i);
        }
        return new int[0];
    }
}
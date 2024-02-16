class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] == nums[i + 1]){
        //         return nums[i];
        //     }
        // }
        // return -1;

        // Another appraoch
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
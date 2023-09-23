class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        //----------Brute Force----------------

        // for(int i = 0; i < n; i++){
        //     for(int j = i + 1; j < n; j++){
        //         if(nums[i] == nums[j] && Math.abs(i - j) <= k)
        //         return true;
        //     }
        // }
        // return false;

        //-----------Using HashMap----------
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
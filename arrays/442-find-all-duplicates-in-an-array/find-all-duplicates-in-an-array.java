class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // int n = nums.length;
        // int[] freq = new int[n + 1];

        // for(int num : nums){
        //     freq[num]++;
        // }

        // List<Integer> ans = new ArrayList<>();

        // for(int i = 0; i < n + 1; i++){
        //     if(freq[i] == 2){
        //         ans.add(i);
        //     }
        // }
        // return ans;

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                ans.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }

        // Reset the array back to its original values
        // not mandatory to do this , but good to do during inteview
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }
}
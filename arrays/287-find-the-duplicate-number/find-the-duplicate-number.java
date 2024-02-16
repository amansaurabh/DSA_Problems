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
        // Map<Integer, Integer> freq = new HashMap<>();

        // for(int num : nums){
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }

        // for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
        //     if(entry.getValue() > 1){
        //         return entry.getKey();
        //     }
        // }
        // return -1;

        //Approach 3:

        // int a[] = new int[nums.length+1];

        // for(int i=0; i<nums.length; i++)
        // {
        //     if(a[nums[i]]==1)
        //     return nums[i];
        //     else
        //     a[nums[i]]++;
        // }
        // return 0;

        //Approach 4: Hare and tortise
        int slow = nums[0];
        int fast = nums[0];

        slow = nums[slow];
        fast = nums[nums[fast]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
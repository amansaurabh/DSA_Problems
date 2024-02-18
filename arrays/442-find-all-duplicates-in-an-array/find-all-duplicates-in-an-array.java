class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for(int num : nums){
            freq[num]++;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n + 1; i++){
            if(freq[i] == 2){
                ans.add(i);
            }
        }
        return ans;
    }
}
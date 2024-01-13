class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < n; i++){
            freq.put(nums1[i], i);
        }

        for (int i = 0; i < m; i++) {
            int nextGreater = -1;
            for (int j = i + 1; j < m; j++) {
                if (nums2[j] > nums2[i]) {
                    if(freq.containsKey(nums2[i])){
                        ans[freq.get(nums2[i])] = nums2[j];
                        break;
                    }
                }
            }
        }
 
        return ans;
    }
}
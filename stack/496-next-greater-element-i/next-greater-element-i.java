class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // ++++++++++++ Brute Force ++++++++++++++++

        // int n = nums1.length;
        // int m = nums2.length;

        // int[] ans = new int[n];
        // Arrays.fill(ans, -1);

        // Map<Integer, Integer> freq = new HashMap<>();

        // for(int i = 0; i < n; i++){
        // freq.put(nums1[i], i);
        // }

        // for (int i = 0; i < m; i++) {
        // for (int j = i + 1; j < m; j++) {
        // if (nums2[j] > nums2[i]) {
        // if(freq.containsKey(nums2[i])){
        // ans[freq.get(nums2[i])] = nums2[j];
        // break;
        // }
        // }
        // }
        // }

        // return ans;

        // ++++++++++++++++++++ Using Stack +++++++++++++++++++++

        int n = nums1.length;
        int m = nums2.length;

        int[] ans = new int[n];
        // Arrays.fill(ans, -1);

        Map<Integer, Integer> freq = new HashMap<>();
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            freq.put(nums1[i], i);
        }

        for (int i = m - 1; i >= 0; i--) {
            if (!freq.containsKey(nums2[i])) {
                stk.push(nums2[i]);
            }else{
                int index = freq.get(nums2[i]);
                if (stk.isEmpty()) {
                    ans[index] = -1;
                } else if (stk.peek() > nums2[i]) {
                    ans[index] = stk.peek();
                } else {

                    while (!stk.isEmpty()) {
                        stk.pop();
                        if (stk.isEmpty()) {
                            ans[index] = -1;
                            break;
                        }
                        if (stk.peek() > nums2[i]) {
                            ans[index] = stk.peek();
                            break;
                        }
                    }

                }
                stk.push(nums2[i]);
            }
        }
        return ans;
    }
}
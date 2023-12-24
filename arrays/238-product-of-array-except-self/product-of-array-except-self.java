class Solution {
    public int[] productExceptSelf(int[] nums) {
        //--------- O(nˆ2) Appraoch --------------

        // int n = nums.length;
        // int[] ans = new int[n];
        // for(int i = 0; i < n; i++){
        //     int product = 1;
        //     for(int j = 0; j < n; j++){
        //         if(i == j){
        //             continue;
        //         }
        //         product *= nums[j];
        //     }
        //     ans[i] = product;
        //     // product = 1;
        // }
        // return ans;

        //--------- O(n) Appraoch (but give  / by zero error ) --------------
        // int n = nums.length;
        // int[] ans = new int[n];
        // int product = 1;
        // for(int i : nums) {
        //     product *= i;
        // }
        // for(int i = 0; i < n; i++) {
        //     ans[i] = product / nums[i];
        // }
        // return ans;

        // Time Complexity O(n), but we are now Space of O(n)

        // int n = nums.length;
        // int pre[] = new int[n];
        // int suff[] = new int[n];
        // pre[0] = 1;
        // suff[n - 1] = 1;
        
        // for(int i = 1; i < n; i++) {
        //     pre[i] = pre[i - 1] * nums[i - 1];
        // }
        // for(int i = n - 2; i >= 0; i--) {
        //     suff[i] = suff[i + 1] * nums[i + 1];
        // }
        
        // int ans[] = new int[n];
        // for(int i = 0; i < n; i++) {
        //     ans[i] = pre[i] * suff[i];
        // }
        // return ans;

        // Time Complexity would be O(n) but now, the Space is O(1) 

        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
class Solution {
    public int[] finalPrices(int[] prices) {

        // ------------------------- Brute force -------------------------
        // int j = 0, i = 0;
        // int n = prices.length;
        // int ans[] = new int[n];
        // for (i = 0; i < n; i++) {
        // for (j = i + 1; j < n; j++) {
        // if (prices[j] <= prices[i]) {
        // ans[i] = prices[i] - prices[j];
        // break;
        // }
        // }
        // if (j == prices.length) {
        // ans[i] = prices[i];
        // }
        // }
        // return ans;

        int n = prices.length;

        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() > prices[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                ans[i] = prices[i];
            } else{
                ans[i] = prices[i] - stk.peek();
            }
            stk.push(prices[i]);
        }
        return ans;
    }
}
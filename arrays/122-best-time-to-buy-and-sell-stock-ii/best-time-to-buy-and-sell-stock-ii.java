class Solution {
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int profit = 0;

        // for(int i = 1; i < n; i++){
        //     if(prices[i] > prices[i - 1]){
        //         profit += prices[i] - prices[i - 1];
        //     }
        // }
        // return profit;

        // Another way
        int res = 0; // to find the total profit
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}
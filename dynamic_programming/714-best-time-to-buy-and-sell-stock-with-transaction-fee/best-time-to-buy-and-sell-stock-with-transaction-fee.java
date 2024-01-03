class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int cash = 0; // maximum profit if you do not hold any stock
        int hold = -prices[0]; // maximum profit if you hold a stock

        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
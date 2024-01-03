class Solution {
    public int maxProfit(int[] prices, int fee) {
        // int n = prices.length;
        // if (n <= 1) {
        //     return 0;
        // }

        // int cash = 0; // maximum profit if you do not hold any stock
        // int hold = -prices[0]; // maximum profit if you hold a stock

        // for (int i = 1; i < n; i++) {
        //     cash = Math.max(cash, hold + prices[i] - fee);
        //     hold = Math.max(hold, cash - prices[i]);
        // }

        // return cash;

        //Using DP
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int[] cash = new int[n]; // maximum profit if you do not hold any stock
        int[] hold = new int[n]; // maximum profit if you hold a stock

        cash[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }

        return cash[n - 1];
    }
}
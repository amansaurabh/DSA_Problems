class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxPro = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(maxPro < prices[i] - min){
                maxPro = prices[i] - min;
            }
        }
        return maxPro;
    }
}
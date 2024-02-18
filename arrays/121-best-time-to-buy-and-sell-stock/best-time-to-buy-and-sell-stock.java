class Solution {
    public int maxProfit(int[] prices) {
        // int min = prices[0];
        // int maxPro = 0;
        // for(int i = 1; i < prices.length; i++){
        //     if(prices[i] < min){
        //         min = prices[i];
        //     }else if(maxPro < prices[i] - min){
        //         maxPro = prices[i] - min;
        //     }
        // }
        // return maxPro;

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int price : prices){
            if(price < min){
                min = price;
            }
            else{
                max = Math.max(max, price - min);
            }
        }
        return max;
    }
}
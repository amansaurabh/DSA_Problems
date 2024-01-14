class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--){
            if(stk.isEmpty()){
                ans[i] = prices[i];
            }else if(stk.peek() < prices[i]){
                
                ans[i] = prices[i] - stk.peek();
            }else{
                while(stk.size() > 0 && stk.peek() > prices[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    ans[i] = prices[i];
                }
                else if(stk.peek() < prices[i]){
                    ans[i] = prices[i] - stk.peek();
                }
            }
            stk.push(prices[i]);
        }
        return ans;
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int sum = 0;

        for(int card : cardPoints){
            sum += card;
        }
        if(n == k){
            return sum;
        }
        int ans = 0;
        int window = n - k;
        int windowSum = 0;

        for(int i = 0; i < window - 1; i++){
            windowSum += cardPoints[i];
        }

        for(int i = window - 1; i < n; i++){
            windowSum += cardPoints[i];
            ans = Math.max(ans, sum - windowSum);
            windowSum -= cardPoints[i - (window - 1)];
        }
        return ans;
    }
}
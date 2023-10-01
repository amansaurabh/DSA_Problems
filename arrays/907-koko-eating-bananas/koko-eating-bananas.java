class Solution {
    public int getMaxTime(int[] piles, int hourly){
        int hrs = 0;
        for(int pile : piles){
            hrs += Math.ceil((double)(pile) / (double)(hourly));
        }
        return hrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        while( low <= high){
            int mid = low + (high - low)/2;
            int maxTime = getMaxTime(piles, mid);
            if(maxTime > h){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return low;
    }
}
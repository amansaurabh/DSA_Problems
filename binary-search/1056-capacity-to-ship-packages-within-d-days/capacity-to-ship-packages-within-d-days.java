class Solution {
    private boolean isPossible(int[] weights, int cap, int days){
        int day = 1;
        int load = 0;
        for(int weight : weights){
            if(load + weight > cap){
                day += 1;
                load = weight;
            }else{
                load += weight;
            }
        }
        return day <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(weights, mid, days)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
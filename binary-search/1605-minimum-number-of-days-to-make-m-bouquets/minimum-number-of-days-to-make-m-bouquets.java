class Solution {
    private boolean isPossible(int[] arr, int day, int m, int k){
        int n = arr.length;
        int count = 0;
        int noOfBouquets = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= day){
                count++;
            }else{
                noOfBouquets += count/k;
                count = 0;
            }
        }
        noOfBouquets += count/k;
        return noOfBouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(bloomDay, mid, m, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
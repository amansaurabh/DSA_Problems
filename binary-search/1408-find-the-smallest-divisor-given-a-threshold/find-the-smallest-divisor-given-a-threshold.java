class Solution {
    
    private static boolean isPossible(int arr[], int limit, int divisor){
        int n = arr.length;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            ans += Math.ceil((double)(arr[j]) / (double)(divisor));
        }
        return ans <= limit;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(isPossible(nums, threshold, mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
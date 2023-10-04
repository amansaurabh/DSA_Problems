class Solution {

    private boolean isPossible(int[] nums, int subArrSum, int splits){
        int n = nums.length;
        int split = 1;
        long prevSum = 0;
        for(int i = 0; i < n; i++){
            if(prevSum + nums[i] <= subArrSum){
                prevSum += nums[i];
            }else{
                split++;
                prevSum = nums[i];
            }
        }
        return split > splits;
    }
    public int splitArray(int[] nums, int k) {

        if(nums.length < k) return -1;
        
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(nums, mid, k)){
                low = mid + 1;
            }
            else{
                high = mid - 1; 
            }
        }

        return low;
    }
}
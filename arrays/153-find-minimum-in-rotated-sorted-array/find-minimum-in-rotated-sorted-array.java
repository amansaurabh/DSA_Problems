class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            // Check for sorted part
            if(nums[low] <= nums[mid]){
                if(nums[low] <= smallest){
                    smallest = nums[low];
                }
                low = mid + 1;
            }else{
                if(nums[mid] <= smallest){
                    smallest = nums[mid];
                }
                high = mid - 1;
            }
        }
        return smallest;
    }
}
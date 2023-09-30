class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        //----------Linear Search-------

        // for(int i = 0 ; i < n; i++){
        //     if(nums[i] == target){
        //         return i;
        //     }
        // }
        // return -1;

        //---------Binary Search----------
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            //Find out sorted part
            // 1: left part is sorted
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            //2: Right half is sorted
            else {
                if(nums[mid] <= target && target <= nums[end] ){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
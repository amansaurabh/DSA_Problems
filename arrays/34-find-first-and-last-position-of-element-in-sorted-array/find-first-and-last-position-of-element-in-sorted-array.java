class Solution {
    public int[] searchRange(int[] nums, int target) {
       int start = 0;
       int end = nums.length - 1;
       int si = -1, ei = -1;
       while(start <= end){
           if(nums[start] == target){
               si = start;
           }else{
               start++;
           }
           if(nums[end] == target){
               ei = end;
           }else{
               end--;
           }
           if(si != -1 && ei != -1) return new int[] {si, ei};
       }
       return new int[] {si, ei};
    }
}
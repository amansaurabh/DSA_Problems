class Solution {
    public int[] searchRange(int[] nums, int target) {
        // my own thinking wala solution

    //    int start = 0;
    //    int end = nums.length - 1;
    //    int si = -1, ei = -1;
    //    while(start <= end){
    //        if(nums[start] == target){
    //            si = start;
    //        }else{
    //            start++;
    //        }
    //        if(nums[end] == target){
    //            ei = end;
    //        }else{
    //            end--;
    //        }
    //        if(si != -1 && ei != -1) return new int[] {si, ei};
    //    }
    //    return new int[] {si, ei};


    //-------------- using BS ------------------------

    int start=0,end=nums.length-1,fi=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                fi=mid;
                end=mid-1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        start=0;end=nums.length-1;
        int ei=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
           if(nums[mid]==target){
                ei=mid;
                start=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return new int[]{fi,ei};
    }
}
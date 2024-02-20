class Solution {
    public boolean canJump(int[] nums) {
        // int reachable = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(i > reachable) return false;
        //     reachable = Math.max(reachable, i + nums[i]);
        // }
        // return true;



        // --------------------------- Anohter method to do ----------------------------
        //Intially final position is the last index
        int finalPosition = nums.length - 1;

        // Start from second last index
        for(int i = nums.length - 2; i >= 0; i--){
            //If u reach the final position from this index
            // update the final position flag and check from indicies

            if(nums[i] >= finalPosition - i){
                finalPosition = i;
            }
        }
        return finalPosition == 0;
    }
}
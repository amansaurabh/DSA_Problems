class Solution {
    public int[] twoSum(int[] nums, int target) {

        //using 2 pointer
        
        //  int left = 0 , right = nums.length - 1 , tempSum;
        // while(left < right)
        // {
        //     tempSum = nums[left] + nums[right];
        //     if(tempSum == target)
        //         return new int[]{left, right};
        //     if(tempSum > target)
        //         right--;
        //     else
        //         left++;
        // }
        // return new int[]{right , left};
        // for(int i = 0 ; i < nums.length - 1 ; i++)
        //     for(int j = i + 1 ; j < nums.length ; j++)
        //     {
        //         if(nums[i] + nums[j] == target)
        //             return new int[]{i, j };
        //     }
        // return new int[]{-1 , -1};
        
         HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            Integer requiredNum = (Integer)(target - nums[i]);
            if(indexMap.containsKey(requiredNum)){
                int toReturn[] = {indexMap.get(requiredNum), i};
                return toReturn;
            }

            indexMap.put(nums[i], i);
        }
        return null;
    }
}
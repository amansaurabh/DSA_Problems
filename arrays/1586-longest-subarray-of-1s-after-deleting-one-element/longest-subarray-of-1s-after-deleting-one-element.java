class Solution {
    public int longestSubarray(int[] nums) {
         int count=0;
        List<Integer> nm=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                if(count>0)
                {
                    nm.add(count);
                    count=0;
                }
                nm.add(0);
            }
            else
            {
                count++;
            }
        }
        nm.add(count);
        if(nm.size()==1)
        {
            return nums.length-1;
        }
        if(nm.size()==2)
        {
            return Math.max(nm.get(0),nm.get(1));
        }
        int max=0;
        for(int i=0;i<nm.size()-2;i++)
        {
            max=Math.max(max,nm.get(i)+nm.get(i+2));
        }
        return max;
    }
}
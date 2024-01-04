class Solution {
    public int minOperations(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int operations = 0;

        for (int count : map.values()) {
            operations += Math.ceil((double)count / 3);
            if(count == 1){
                return -1;
            }
        }
        return operations;
    }
}
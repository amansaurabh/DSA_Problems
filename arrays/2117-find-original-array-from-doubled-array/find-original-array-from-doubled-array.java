class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        Map<Integer, Integer> originalSet = new HashMap<>();

        Arrays.sort(changed);

        if(n % 2 != 0){
            return new int[]{};
        }

        for (int num : changed) {
            originalSet.put(num, originalSet.getOrDefault(num, 0) + 1);
        }

        int[] original = new int[n/2];
        int index = 0;
        for (int num : changed) {
            int twice = 2 * num;
            if(originalSet.get(num) <= 0) continue;
            if(originalSet.getOrDefault(twice,0) <= 0){
                return new int[]{};
            }
                original[index++] = num;
                originalSet.put(num, originalSet.get(num) - 1);
                originalSet.put(twice, originalSet.get(twice) - 1);
        }
        return original;
         
    }
}
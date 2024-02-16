class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies);

        int uniqueInteger = frequencies.size();
        int removedElements = 0;

        for(int freq : frequencies){
            if(removedElements + freq <= k){
                removedElements += freq;
                uniqueInteger--;
            }else{
                break;
            }
        }
        return uniqueInteger;
    }
}
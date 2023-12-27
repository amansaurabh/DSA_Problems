class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // int n = arr.length;

        // Map<Integer, Integer> map = new HashMap<>();

        // for(int el : arr){
        //     if(map.containsKey(el)){
        //         map.put(el, map.get(el) + 1);
        //     }
        //     else{
        //         map.put(el, map.getOrDefault(el, 0) + 1);
        //     }
        // }
        // return map.size() == new HashSet<>(map.values()).size();


        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of occurrences of each number in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> frequencySet = new HashSet<>(frequencyMap.values());

        // If the size of the set matches the number of unique frequencies, return true; otherwise, return false
        return frequencySet.size() == frequencyMap.size();
    }
}
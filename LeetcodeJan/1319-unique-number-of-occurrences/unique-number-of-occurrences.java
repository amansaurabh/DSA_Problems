class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        // Map<Integer, Integer> frequencyMap = new HashMap<>();

        // // Count the frequency of occurrences of each number in the array
        // for (int num : arr) {
        //     frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        // }

        // Set<Integer> frequencySet = new HashSet<>(frequencyMap.values());

        // // If the size of the set matches the number of unique frequencies, return true; otherwise, return false
        // return frequencySet.size() == frequencyMap.size();

        int[] freq = new int[2001];

        for(int x : arr){
            freq[1000 + x]++;
        }

        Arrays.sort(freq);
        
        for(int i = 1; i < 2001; i++){
            if(freq[i] != 0 && freq[i] == freq[i - 1]){
                return false;
            }
        }

        return true;
    }
}
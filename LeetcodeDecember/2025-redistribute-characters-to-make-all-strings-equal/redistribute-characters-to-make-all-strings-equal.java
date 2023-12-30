class Solution {
    public boolean makeEqual(String[] words) {
        // Map<Character, Integer> mp = new HashMap<>();
        // for(String str : words){
        //     for(char ch : str.toCharArray()){
        //         mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        //     }
        // }

        // int n = words.length;

        // for(int count : mp.values()){
        //     if(count % n != 0){
        //         return false;
        //     }
        // }
        // return true;

    int[] charCount = new int[26]; // only lowercase English letters

    // Count occurrences of each character in all words
    for (String word : words) {
        for (char ch : word.toCharArray()) {
            charCount[ch - 'a']++;
        }
    }

    int n = words.length;
    for (int count : charCount) {
        if (count % n != 0) {
            return false; // If any character count is not divisible by the total number of words
        }
    }

    return true;
    }
}
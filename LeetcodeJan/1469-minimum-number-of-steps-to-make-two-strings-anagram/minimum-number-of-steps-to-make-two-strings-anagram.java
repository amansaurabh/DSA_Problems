class Solution {
    public int minSteps(String s, String t) {
        // Map<Character, Integer> countMap = new HashMap<>();

        // // Update counts for string s
        // for (char c : s.toCharArray()) {
        //     countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        // }

        // // Update counts for string t and calculate absolute differences
        // int steps = 0;
        // for (char c : t.toCharArray()) {
        //     countMap.put(c, countMap.getOrDefault(c, 0) - 1);
        //     if (countMap.get(c) < 0) {
        //         // Character not present in s or extra occurrences in t
        //         steps++;
        //     }
        // }

        // return steps;

        // ----------- using array to store ----------------------------


        int[] charFreq = new int[26];

        for(char cur: s.toCharArray()) {
            charFreq[cur-'a']++;
        }

        for(char cur: t.toCharArray()) {
            charFreq[cur-'a']--;
        }

        int minSteps = 0;

        for(int idx=0; idx < 26; idx++) {
            if (charFreq[idx] > 0) {
                minSteps += charFreq[idx];
            }
        }

        return minSteps;
    }
}
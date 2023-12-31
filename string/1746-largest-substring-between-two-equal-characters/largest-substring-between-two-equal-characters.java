class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // int n = s.length();
        // Map<Character, Integer> charIndices = new HashMap<>();
        // int maxLength = -1;

        // for (int i = 0; i < n; i++) {
        //     char ch = s.charAt(i);
        //     if (charIndices.containsKey(ch)) {
        //         int prevIndex = charIndices.get(ch);
        //         maxLength = Math.max(maxLength, i - prevIndex - 1);
        //     } else {
        //         charIndices.put(ch, i);
        //     }
        // }

        // return maxLength;


        int maxLength = -1;
        int[] indices = new int[26]; // Assuming lowercase English letters

        // Initialize the indices array with -1 (unvisited)
        for (int i = 0; i < 26; i++) {
            indices[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (indices[ch - 'a'] == -1) {
                indices[ch - 'a'] = i; // Store the first occurrence index of the character
            } else {
                maxLength = Math.max(maxLength, i - indices[ch - 'a'] - 1);
            }
        }

        return maxLength;
    }
}
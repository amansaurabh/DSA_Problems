class Solution {
    public int countCharacters(String[] words, String chars) {
        // int[] charCounts = new int[26]; // Assuming lowercase English letters
        // int totalLength = 0;

        // // Count occurrences of characters in chars
        // for (char c : chars.toCharArray()) {
        //     charCounts[c - 'a']++;
        // }

        // for (String word : words) {
        //     int[] tempCounts = new int[26];
        //     boolean canForm = true;

        //     // Count occurrences of characters in the current word
        //     for (char c : word.toCharArray()) {
        //         tempCounts[c - 'a']++;
        //     }

        //     // Check if the word can be formed using characters from chars
        //     for (int i = 0; i < 26; i++) {
        //         if (tempCounts[i] > charCounts[i]) {
        //             canForm = false;
        //             break;
        //         }
        //     }

        //     if (canForm) {
        //         totalLength += word.length();
        //     }
        // }

        // return totalLength;


        //---- using Hashmap-----

        int totalLength = 0;
        Map<Character, Integer> charsCount = new HashMap<>();

        // Count occurrences of characters in chars
        for (char c : chars.toCharArray()) {
            charsCount.put(c, charsCount.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            Map<Character, Integer> wordCount = new HashMap<>();

            // Count occurrences of characters in the current word
            for (char c : word.toCharArray()) {
                wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
            }

            boolean canForm = true;

            // Check if the word can be formed using characters from chars
            for (Map.Entry<Character, Integer> entry : wordCount.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();

                if (!charsCount.containsKey(c) || charsCount.get(c) < count) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}
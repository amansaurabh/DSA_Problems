class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCounts = new int[26]; // Assuming lowercase English letters
        int totalLength = 0;

        // Count occurrences of characters in chars
        for (char c : chars.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (String word : words) {
            int[] tempCounts = new int[26];
            boolean canForm = true;

            // Count occurrences of characters in the current word
            for (char c : word.toCharArray()) {
                tempCounts[c - 'a']++;
            }

            // Check if the word can be formed using characters from chars
            for (int i = 0; i < 26; i++) {
                if (tempCounts[i] > charCounts[i]) {
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
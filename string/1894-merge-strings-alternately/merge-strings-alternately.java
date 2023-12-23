class Solution {
    public String mergeAlternately(String word1, String word2) {
        // StringBuilder merged = new StringBuilder();
        // int len1 = word1.length();
        // int len2 = word2.length();
        // int minLength = Math.min(len1, len2);

        // for (int i = 0; i < minLength; i++) {
        //     merged.append(word1.charAt(i)).append(word2.charAt(i));
        // }

        // if (len1 > len2) {
        //     merged.append(word1.substring(minLength));
        // } else if (len2 > len1) {
        //     merged.append(word2.substring(minLength));
        // }

        // return merged.toString();

        // another approach
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}
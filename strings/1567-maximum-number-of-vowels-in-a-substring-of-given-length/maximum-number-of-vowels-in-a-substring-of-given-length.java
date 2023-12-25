class Solution {
    public int maxVowels(String s, int k) {
        int maxVowelsCount = 0;
        int currentVowelsCount = 0;

        // Define a set of vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Calculate the count of vowels in the first substring of length k
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowelsCount++;
            }
        }
        maxVowelsCount = currentVowelsCount; // Initialize max count

        // Use sliding window approach to traverse the string and find maximum vowel count
        for (int i = k; i < s.length(); i++) {
            // Remove the leftmost character from the window
            if (vowels.contains(s.charAt(i - k))) {
                currentVowelsCount--;
            }

            // Add the new character to the window
            if (vowels.contains(s.charAt(i))) {
                currentVowelsCount++;
            }

            // Update max count if the current count is greater
            maxVowelsCount = Math.max(maxVowelsCount, currentVowelsCount);

            // If the maximum possible vowels (k) are found, break the loop
            if (maxVowelsCount == k) {
                break;
            }
        }

        return maxVowelsCount;
    }
}
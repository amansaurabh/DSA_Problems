class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        Map<Character, Integer> charIndices = new HashMap<>();
        int maxLength = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (charIndices.containsKey(ch)) {
                int prevIndex = charIndices.get(ch);
                maxLength = Math.max(maxLength, i - prevIndex - 1);
            } else {
                charIndices.put(ch, i);
            }
        }

        return maxLength;
    }
}
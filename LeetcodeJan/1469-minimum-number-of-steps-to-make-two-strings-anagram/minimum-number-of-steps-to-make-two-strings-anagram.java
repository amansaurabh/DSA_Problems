class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();

        // Update counts for string s
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Update counts for string t and calculate absolute differences
        int steps = 0;
        for (char c : t.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) - 1);
            if (countMap.get(c) < 0) {
                // Character not present in s or extra occurrences in t
                steps++;
            }
        }

        return steps;
    }
}
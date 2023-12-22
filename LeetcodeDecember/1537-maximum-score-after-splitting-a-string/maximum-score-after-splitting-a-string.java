class Solution {
    public int maxScore(String s) {
        int zerosCount = 0;
        int onesCount = 0;

        // Count total number of ones
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                onesCount++;
            }
        }

        int maxScore = Integer.MIN_VALUE;

        // Iterate through the string to calculate scores
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosCount++;
            } else {
                onesCount--;
            }

            // Calculate score at current position
            int score = zerosCount + onesCount;

            // Update maximum score
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
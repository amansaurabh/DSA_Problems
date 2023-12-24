class Solution {
    public int minOperations(String s) {
        int operationsWithZeroFirst = 0;
        int operationsWithOneFirst = 0;

        // Calculate the number of operations if the first character is '0'
        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expected) {
                operationsWithZeroFirst++;
            }
        }

        // Calculate the number of operations if the first character is '1'
        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected) {
                operationsWithOneFirst++;
            }
        }

        // Return the minimum number of operations needed
        return Math.min(operationsWithZeroFirst, operationsWithOneFirst);
    }
}
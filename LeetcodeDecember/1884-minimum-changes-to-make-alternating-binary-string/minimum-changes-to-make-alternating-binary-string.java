class Solution {
    public int minOperations(String s) {
        int operationsWithZeroFirst = 0;
        int operationsWithOneFirst = 0;

        for (int i = 0; i < s.length(); i++) {
            char expectedZero = (i % 2 == 0) ? '0' : '1';
            char expectedOne = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expectedZero) {
                operationsWithZeroFirst++;
            }

            if (s.charAt(i) != expectedOne) {
                operationsWithOneFirst++;
            }
        }

        return Math.min(operationsWithZeroFirst, operationsWithOneFirst);
    }
}
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Calculate the prefix sum for each submatrix
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int count = 0;

        // Iterate over all pairs of columns (left and right)
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                Map<Integer, Integer> prefixSumCount = new HashMap<>();
                prefixSumCount.put(0, 1);
                int currentSum = 0;

                // Iterate over each row and calculate the sum of submatrices
                for (int row = 0; row < m; row++) {
                    int sum = matrix[row][right] - ((left > 0) ? matrix[row][left - 1] : 0);
                    currentSum += sum;

                    // Check if there is a submatrix with the target sum
                    if (prefixSumCount.containsKey(currentSum - target)) {
                        count += prefixSumCount.get(currentSum - target);
                    }

                    prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
                }
            }
        }

        return count;
    }
}
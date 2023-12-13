class Solution {
    public int numSpecial(int[][] mat) {
        
    // -------------------- Approach 1:-------------------------

        // int rows = mat.length;
        // int cols = mat[0].length;
        // int[] rowCount = new int[rows];
        // int[] colCount = new int[cols];
        // int result = 0;

        // // Count occurrences of 1s in rows and columns
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         if (mat[i][j] == 1) {
        //             rowCount[i]++;
        //             colCount[j]++;
        //         }
        //     }
        // }

        // // Check for special positions
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
        //             result++;
        //         }
        //     }
        // }

        // return result;


    // -------------------- Approach 1:-------------------------

        int specials = 0;

        for (int i = 0; i < mat.length; i++) {
            int index = checkRow(mat, i);
            if (index >= 0 && checkColumn(mat, i, index))
                specials++;
        }

        return specials;
    }

    private int checkRow(int[][] mat, int i) {
        int index = -1;
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] == 1) {
                if (index >= 0)
                    return -1;
                else
                    index = j;
            }
        }
        return index;
    }

    private boolean checkColumn(int[][] mat, int i, int index) {
        for (int j = 0; j < mat.length; j++) {
            if (mat[j][index] == 1 && j != i)
                return false;
        }
        return true;
    }
}
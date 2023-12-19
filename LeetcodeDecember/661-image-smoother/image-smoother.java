class Solution {
    public int[][] imageSmoother(int[][] img) {
        // int rows = img.length;
        // int cols = img[0].length;
        // int[][] result = new int[rows][cols];

        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         result[i][j] = getSmoothedValue(img, i, j);
        //     }
        // }

        // return result;
        int rows = img.length, cols = img[0].length;
        int[][] result = new int[rows][cols];

        int[] dx = {-1, 0, 1}, dy = {-1, 0, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0, count = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int x = i + dx[k], y = j + dy[l];
                        if (isValidCell(img, x, y)) {
                            sum += img[x][y];
                            count++;
                        }
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
    // private int getSmoothedValue(int[][] M, int row, int col) {
    //     int sum = 0;
    //     int count = 0;

    //     for (int i = row - 1; i <= row + 1; i++) {
    //         for (int j = col - 1; j <= col + 1; j++) {
    //             if (isValidCell(M, i, j)) {
    //                 sum += M[i][j];
    //                 count++;
    //             }
    //         }
    //     }

    //     return sum / count;
    // }
    private boolean isValidCell(int[][] M, int row, int col) {
        return row >= 0 && row < M.length && col >= 0 && col < M[0].length;
    }


}
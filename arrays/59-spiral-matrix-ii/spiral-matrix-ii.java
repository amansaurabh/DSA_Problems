class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];

        if(n == 0) return matrix;

        int top   = 0;
        int down  = n-1;
        int left  = 0;
        int right = n-1;

        int dir = 0;
        int num = 1;

        /*
        dir = 0 : left to right
        dir = 1; top to down
        dir = 2; right to left
        dir = 3; down to up
        */

        while(top <= down && left <= right){
            if(dir == 0){
                // left to right
                // constant : Row (top)

                for(int i = left; i <= right; i++){
                    matrix[top][i] = num;
                    num++;
                }
                top++;
            }

            if(dir == 1){
                // top to down
                // constant : Column (right)

                for(int i = top; i <= down; i++){
                    matrix[i][right] = num;
                    num++;
                }
                right--;
            }

            if(dir == 2){
                // right to left
                // constant : Row (down)

                for(int i = right; i >= left; i--){
                    matrix[down][i] = num;
                    num++;
                }
                down--;
            }

            if(dir == 3){
                // down to top
                // constant : Column (left)

                for(int i = down; i >= top; i--){
                    matrix[i][left] = num;
                    num++;
                }
                left++;
            }
            dir += 1;
            if(dir == 4){
                dir = 0;
            }
        }
        return matrix;
    }
}
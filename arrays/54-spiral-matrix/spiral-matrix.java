class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; // row
        int n = matrix[0].length; // col

        int top   = 0;
        int down  = m-1;
        int left  = 0;
        int right = n-1;

        int dir = 0;

        /*
        dir = 0 : left to right
        dir = 1; top to down
        dir = 2; right to left
        dir = 3; down to up
        */

        List<Integer> res = new ArrayList<>();
        if( m == 0 || n == 0) return res;

        while(top <= down && left <= right){
            if(dir == 0){
                // left to right
                // constant : Row (top)

                for(int i = left; i <= right; i++){
                    res.add(matrix[top][i]);
                }
                top++;
            }

            if(dir == 1){
                // top to down
                // constant : Column (right)

                for(int i = top; i <= down; i++){
                    res.add(matrix[i][right]);
                }
                right--;
            }

            if(dir == 2){
                // right to left
                // constant : Row (down)

                for(int i = right; i >= left; i--){
                    res.add(matrix[down][i]);
                }
                down--;
            }

            if(dir == 3){
                // down to top
                // constant : Column (left)

                for(int i = down; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
            dir += 1;
            if(dir == 4){
                dir = 0;
            }
        }
        return res;
    }
}
class Solution {
    int m, n, l;
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private boolean find(int x, int y, char[][] board, String word, int idx){
        if(idx >= l){
            return true;
        }
        if(x < 0 || y < 0 || x >= m || y >= n || board[x][y] != word.charAt(idx)){
            return false;
        }
        char temp = board[x][y];
        board[x][y] = '$';

        for(int[] dir : dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(find(newX, newY, board, word, idx + 1)){
                return true;
            }
        }
        board[x][y] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();

        if(m * n < l){
            return false;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && find(i, j, board, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
}
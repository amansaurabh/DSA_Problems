class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowOnes[i] += 1;
                    colOnes[j] += 1;
                }
            }
        }
        
        int[][] diff = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int onesRowi = rowOnes[i];
                int onesColj = colOnes[j];
                int zerosRowi = m - rowOnes[i];
                int zerosColj = n - colOnes[j];
                diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj;
            }
        }
        return diff;    
    }
}
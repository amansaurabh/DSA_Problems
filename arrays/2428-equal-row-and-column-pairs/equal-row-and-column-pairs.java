class Solution {
    public int equalPairs(int[][] grid) {

        int n = grid.length;
        //int n = grid[0].length;

        int count = 0;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                int is_equal = 1;
                for(int i = 0; i < n; i++){
                    if(grid[r][i] != grid[i][c]){
                        is_equal = 0;
                        break;
                    }
                }
                count += is_equal;
            }
        }

        // int n = grid.length;
        // Map<List<Integer>, Integer> rowCounts = new HashMap<>();
        // Map<List<Integer>, Integer> colCounts = new HashMap<>();
        // int count = 0;

        // // Count occurrences of rows and columns
        // for (int i = 0; i < n; i++) {
        //     List<Integer> rowList = new ArrayList<>();
        //     List<Integer> colList = new ArrayList<>();

        //     for (int j = 0; j < n; j++) {
        //         rowList.add(grid[i][j]);
        //         colList.add(grid[j][i]);
        //     }

        //     rowCounts.put(rowList, rowCounts.getOrDefault(rowList, 0) + 1);
        //     colCounts.put(colList, colCounts.getOrDefault(colList, 0) + 1);
        // }

        // // Calculate the number of pairs where a row and column are equal
        // for (List<Integer> rowList : rowCounts.keySet()) {
        //     int rowOccurrences = rowCounts.get(rowList);
        //     count += rowOccurrences * (rowOccurrences - 1) / 2;
        // }

        // for (List<Integer> colList : colCounts.keySet()) {
        //     int colOccurrences = colCounts.get(colList);
        //     count += colOccurrences * (colOccurrences - 1) / 2;
        // }

        return count;
    }
}
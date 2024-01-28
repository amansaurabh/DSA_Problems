class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int arr[][]=new int[n+1][m+1];
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        
        for(int i = 1; i <=n; ++i){
            for(int j = 1; j <=m; ++j){
                
              for(int k = 0; k <= (n - i); ++k){
                for(int p = 0; p <= (m - j); ++p){
                    
                    int sum=arr[i+k][j+p]+arr[k][p]-arr[i+k][p]-arr[k][j+p];
                    if(sum==target){
                        count++;
                    }
                    
                }
              }
            }
          }
        return count;
    }
}
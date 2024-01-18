class Solution {
    // private int climb(int n, int[] memo){
    //     if(n < 0) return 0;
    //     if (memo[n] != -1) return memo[n]; 
    //     if (n == 0) return 1;
    //     int one_step = climb(n-1, memo);
    //     int two_step = climb(n-2, memo);
    //     return memo[n] = one_step + two_step;
    // }    
    public int climbStairs(int n) {
        //Brute Force
        // if(n < 0) return 0;
        // if (n == 0) return 1;
        // int one_step = climbStairs(n-1);
        // int two_step = climbStairs(n-2);
        // return one_step + two_step;

        //Memo
        // int[] memo = new int[n + 1];
        // Arrays.fill(memo, -1);
        // return climb(n, memo);

        //Bottom UP
        // int[] t = new int[n+1];
        if(n == 1 || n == 2) return n;
        // t[0] = 0;
        // t[1] = 1;
        // t[2] = 2;
        int a = 1; // i-1
        int b = 2; // i-2
        int c = 3; // i-3
        for(int i = 3; i <= n; i++){
            c = b + a;
            int temp = b;
            b = c;
            a = temp;
        }
        return c;
    }
}
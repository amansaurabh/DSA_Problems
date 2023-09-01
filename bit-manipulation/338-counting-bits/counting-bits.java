class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
    
        for (int i = 1; i <= n; i++) {
            // Use the fact that ans[i] = ans[i / 2] + (i % 2)
            ans[i] = ans[i >> 1] + (i & 1);

            //Brute- force solution
            ans[i] = countOnes(i);
        }
        
        return ans;
    }

    private int countOnes(int num) {
    int count = 0;
    while (num > 0) {
        count += num & 1;
        num >>= 1;
    }
    return count;
    }
}
class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        for (int i = 0; i < 32; i++) { // Assuming integers are 32-bit
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;
            
            // Check if the OR of a and b at bit i is not equal to c at bit i
            if ((bitA | bitB) != bitC) {
                // If c has 1 at bit i, need to flip both a and b
                if (bitC == 1) {
                    flips += 1;
                }
                // If c has 0 at bit i, need to flip one of a or b if both have 1 at bit i
                else if (bitA == 1 && bitB == 1) {
                    flips += 2;
                } else {
                    flips += 1; // Only one of a or b needs to be flipped to 1
                }
            }
        }
        
        return flips;
    }
}
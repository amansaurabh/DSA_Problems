class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // Convert low and high to strings to determine their lengths
        String lowStr = String.valueOf(low);
        String highStr = String.valueOf(high);
        int lowLen = lowStr.length();
        int highLen = highStr.length();
        
        // Generate all possible sequential digits
        String sequential = "123456789";
        for (int len = lowLen; len <= highLen; len++) {
            for (int i = 0; i <= 9 - len; i++) {
                String candidate = sequential.substring(i, i + len);
                int num = Integer.parseInt(candidate);
                
                // Check if the generated number is within the specified range
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        Collections.sort(result);
        return result;
    }
}
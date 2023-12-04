class Solution {
    public String largestGoodInteger(String num) {
        String maxChar = "";
        int n = num.length();

        for(int i = 2; i < n ; i++){
            if(num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)){
                String currentSubstring = num.substring(i-2, i+1);
                if(maxChar.compareTo(currentSubstring) < 0){
                    maxChar = currentSubstring;
                }
            }
        }
        return maxChar;
    }
}
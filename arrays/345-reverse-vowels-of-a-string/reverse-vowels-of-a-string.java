class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        StringBuilder rev = new StringBuilder();
        int n = s.length();

        for(int i = n - 1; i >= 0; i--){
            if(vowel.contains(String.valueOf(s.charAt(i)))){
                rev.append(s.charAt(i));
            }
        }
        String revStr = rev.toString();

        StringBuilder ans = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()){
            if(vowel.contains(String.valueOf(c))){
                ans.append(revStr.charAt(i));
                i++;
            } else{
                ans.append(c);
            }
            
        }
        return ans.toString();
    }
}
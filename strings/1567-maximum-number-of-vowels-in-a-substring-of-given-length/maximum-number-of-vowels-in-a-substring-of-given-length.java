class Solution {
    public int maxVowels(String s, int k) {
        String vowel = "aeiou";

        int totalVowel = 0;
        

        for(int i = 0; i < k; i++){
            if(vowel.indexOf(s.charAt(i)) != -1){
                totalVowel++;
            }
        }
        int maxVowel = totalVowel;

        for(int i = k; i < s.length(); i++){
            if(vowel.indexOf(s.charAt(i)) != -1){
                totalVowel++;
            }
            if(vowel.indexOf(s.charAt(i - k)) != -1){
                totalVowel--;
            }

            maxVowel = Math.max(maxVowel, totalVowel);
        }
        return maxVowel;
    }
}
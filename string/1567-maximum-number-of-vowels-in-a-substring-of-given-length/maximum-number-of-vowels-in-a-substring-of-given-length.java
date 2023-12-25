class Solution {
    public int maxVowels(String s, int k) {
        // String vowel = "aeiou";

         // Define a set of vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int totalVowel = 0;
        

        for(int i = 0; i < k; i++){
            if(vowels.contains(s.charAt(i))){
                totalVowel++;
            }
        }
        int maxVowel = totalVowel;

        for(int i = k; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                totalVowel++;
            }
            if(vowels.contains(s.charAt(i - k))){
                totalVowel--;
            }

            maxVowel = Math.max(maxVowel, totalVowel);
        }
        return maxVowel;
    }
}
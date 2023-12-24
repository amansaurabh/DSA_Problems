class Solution {
    public String reverseVowels(String s) {
        // String vowel = "aeiouAEIOU";
        // StringBuilder rev = new StringBuilder();
        // int n = s.length();

        // for(int i = n - 1; i >= 0; i--){
        //     if(vowel.contains(String.valueOf(s.charAt(i)))){
        //         rev.append(s.charAt(i));
        //     }
        // }
        // String revStr = rev.toString();

        // StringBuilder ans = new StringBuilder();
        // int i = 0;
        // for(char c : s.toCharArray()){
        //     if(vowel.contains(String.valueOf(c))){
        //         ans.append(revStr.charAt(i));
        //         i++;
        //     } else{
        //         ans.append(c);
        //     }
            
        // }
        // return ans.toString();


        //--------- Optimize solution ---------
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        // Define the set of vowels
        String vowels = "aeiouAEIOU";

        while (left < right) {
            // Find the left vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }

            // Find the right vowel
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
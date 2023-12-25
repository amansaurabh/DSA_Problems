class Solution {
    public boolean isSubsequence(String s, String t) {
        // int sIndex = 0; // Pointer for string s
        // int tIndex = 0; // Pointer for string t

        // // Loop through both strings
        // while (sIndex < s.length() && tIndex < t.length()) {
        //     // If characters match, move sIndex to the next character in s
        //     if (s.charAt(sIndex) == t.charAt(tIndex)) {
        //         sIndex++;
        //     }
        //     // Move tIndex to the next character in t in any case
        //     tIndex++;
        // }

        // // If sIndex reaches the end of s, then all characters in s were found in t in order
        // return sIndex == s.length();


        if(s.length()>t.length()) {
            return false;
        }
        if(s.length()==0 || t.length()==0) {
            return true;
        }

        if(s.length()==0) return true;

        int slen = s.length();
        int tlen = t.length();

        int i = 0;
        int j = 0;

        while(i < slen && j < tlen) {
            if(s.charAt(i) == t.charAt(j)) {
                i++; j++;
                if(i==slen)
                    return true;
            }
            else {
                j++;
            }
        }
        return false;
    }
}
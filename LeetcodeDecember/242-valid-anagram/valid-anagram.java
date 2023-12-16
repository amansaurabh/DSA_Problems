class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        // int[] count = new int[128];

        // for(char ch : s.toCharArray()){
        //     count[ch - 'a']++;
        // } 

        // for(char ch : t.toCharArray()){
        //     if(--count[ch - 'a'] < 0) return false;
        // } 
        // return true;
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for(char ch : s.toCharArray()){
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }
        for(char ch : t.toCharArray()){
            if(!charFreq.containsKey(ch)) return false;
            else{
                charFreq.put(ch, charFreq.get(ch) - 1);
                if(charFreq.get(ch) < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
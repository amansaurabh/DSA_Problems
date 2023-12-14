class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] lettercount = new int[26];
        for(char letter : letters){
            lettercount[letter - 'a']++;
        }
        return backtrack(words, lettercount, score, 0);
    }
    private int backtrack(String[] words, int[] lettercount, int[] score, int idx){
        if(idx == words.length){
            return 0;
        }
        // Every word has two choice : Yes Or No
        // if that word dont want to join then
        int scoreWithoutWord = backtrack(words, lettercount, score, idx + 1);

        int scoreWord = 0;
        String word = words[idx];
        boolean flag = true;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(lettercount[ch - 'a'] == 0){
                flag = false;
                
            }
            lettercount[ch - 'a']--;
            scoreWord += score[ch - 'a'];
        }

        // Calculate score using the current word if possible
        int scoreWithWord = 0;
        if(flag){
            scoreWithWord += scoreWord + backtrack(words, lettercount, score, idx + 1);
        }

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            lettercount[ch - 'a']++;
        }
        // Return the maximum score between using and not using the current word
        return Math.max(scoreWithWord, scoreWithoutWord);
    }
}
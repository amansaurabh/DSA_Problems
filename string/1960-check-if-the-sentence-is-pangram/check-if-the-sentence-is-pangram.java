class Solution {
    public boolean checkIfPangram(String sentence) {
        // Using A to Z string

        // String atoz = "abcdefghijklmnopqrstuvwxyz";
        // for(int i = 0; i < atoz.length(); i++){
        //     char ch = atoz.charAt(i);
        //     if(sentence.indexOf(ch) == -1){
        //         return false;
        //     }
        // }
        // return true;

        // Using alphabet Array
        boolean[] alphaPresence = new boolean[26];

        for(int i = 0; i < sentence.length(); i++){
            char ch = sentence.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                alphaPresence[ch - 'a'] = true;
            }
        }
        for(boolean alpha : alphaPresence){
            if(!alpha){
                return false;
            }
        }
        return true;
    }
}
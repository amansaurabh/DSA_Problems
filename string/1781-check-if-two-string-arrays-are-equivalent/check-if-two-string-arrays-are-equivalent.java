class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String conWord1 = "";
        String conWord2 = "";

        for(String word : word1){
            conWord1 += word;
        }

        for(String word : word2){
            conWord2 += word;
        }

        if(conWord1.equals(conWord2)) return true;
        else return false;

        //------------Another method-----------------------

        
    }
}
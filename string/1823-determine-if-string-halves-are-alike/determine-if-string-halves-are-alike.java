class Solution {

    private boolean isVolwel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int countLeft = 0;
        int countRight = 0;
        for(int i = 0; i < n/2; i++){
            if(isVolwel(s.charAt(i))){
                countLeft++;
            }
        }

        for(int i = n/2; i < n; i++){
            if(isVolwel(s.charAt(i))){
                countRight++;
            }
        }
        if(countRight == countLeft){
            return true;
        }
        return false;
    }
}
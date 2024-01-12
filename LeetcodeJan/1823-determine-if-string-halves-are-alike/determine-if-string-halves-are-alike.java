// class Solution {

//     private boolean isVolwel(char ch){
//         return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
//     }
//     public boolean halvesAreAlike(String s) {
//         int n = s.length();
//         int countLeft = 0;
//         int countRight = 0;
//         for(int i = 0; i < n/2; i++){
//             if(isVolwel(s.charAt(i))){
//                 countLeft++;
//             }
//         }

//         for(int i = n/2; i < n; i++){
//             if(isVolwel(s.charAt(i))){
//                 countRight++;
//             }
//         }
//         if(countRight == countLeft){
//             return true;
//         }
//         return false;
//     }
// }


// ---------------------- another approach ------------------------

class Solution {
     public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);
        
        int countFirst = countVowels(firstHalf);
        int countSecond = countVowels(secondHalf);
        
        return countFirst == countSecond;
    }
    
    private int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
class Solution {
    public int compress(char[] chars) {
       int i = 0;
       int j = 0; 
       int n = chars.length;
       while( j < n){
           char currChar = chars[j];
           int count = 0;
           while(j < n && chars[j] == currChar){
               j++;
               count++;
           }
           chars[i] = currChar;
           i++;
           if(count > 1){
               for (char digit : String.valueOf(count).toCharArray()) {
                   chars[i] = digit;
                   i++;
               }
           }
       } 
       return i;
    }
}
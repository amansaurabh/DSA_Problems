class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String prev = countAndSay(n - 1);
        return generateNext(prev);
    }
     private String generateNext(String prev) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for(int i = 1; i < prev.length(); i++){
            if(prev.charAt(i) == prev.charAt(i-1)){
                count++;
            }else{
                result.append(count);
                result.append(prev.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count);
        result.append(prev.charAt(prev.length() - 1));
        return result.toString();
     }
}
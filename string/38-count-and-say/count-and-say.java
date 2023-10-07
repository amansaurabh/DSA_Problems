class Solution {
    public String countAndSay(int n) {

    //--------------Using recursion----------------

    //     if(n == 1) return "1";
    //     String prev = countAndSay(n - 1);
    //     return generateNext(prev);
    // }
    //  private String generateNext(String prev) {
    //     StringBuilder result = new StringBuilder();
    //     int count = 1;

    //     for(int i = 1; i < prev.length(); i++){
    //         if(prev.charAt(i) == prev.charAt(i-1)){
    //             count++;
    //         }else{
    //             result.append(count);
    //             result.append(prev.charAt(i - 1));
    //             count = 1;
    //         }
    //     }
    //     result.append(count);
    //     result.append(prev.charAt(prev.length() - 1));
    //     return result.toString();



    // Without recursion

    String result = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            
            temp.append(count);
            temp.append(result.charAt(result.length() - 1));
            result = temp.toString();
        }
        
        return result;
    }
}
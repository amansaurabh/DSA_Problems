class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        //-------------------0(n)-----------------
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= 8; i++){
            q.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr >= low && curr <= high){
                result.add(curr);
            }
            int lastDigit = curr % 10;

            if(lastDigit + 1 <= 9){
                q.offer(curr * 10 + (lastDigit + 1));
            }
        }

        return result;

        
        // List<Integer> result = new ArrayList<>();
        
        // // Convert low and high to strings to determine their lengths
        // String lowStr = String.valueOf(low);
        // String highStr = String.valueOf(high);
        // int lowLen = lowStr.length();
        // int highLen = highStr.length();
        
        // // Generate all possible sequential digits
        // String sequential = "123456789";
        // for (int len = lowLen; len <= highLen; len++) {
        //     for (int i = 0; i <= 9 - len; i++) {
        //         String candidate = sequential.substring(i, i + len);
        //         int num = Integer.parseInt(candidate);
                
        //         // Check if the generated number is within the specified range
        //         if (num >= low && num <= high) {
        //             result.add(num);
        //         }
        //     }
        // }
        
        // Collections.sort(result);
        // return result;
    }
}
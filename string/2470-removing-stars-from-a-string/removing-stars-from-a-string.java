class Solution {
    public String removeStars(String s) {
        // Stack<Character> stk = new Stack<>();

        // for(char ch : s.toCharArray()){
        //     if(ch == '*'){
        //         if (!stk.isEmpty() && stk.peek() != '*') {
        //         stk.pop();
        //         }
        //     }
        //     else{
        //         stk.push(ch);
        //     }
            
        // }

        // StringBuilder ans = new StringBuilder();
        // while(!stk.isEmpty()){
        //     ans.append(stk.pop());
        // }
        // return ans.reverse().toString();

        StringBuilder c = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                c.deleteCharAt(c.length() - 1);
            } else {
                c.append(s.charAt(i));
            }
        }
        return c.toString();
    }
}
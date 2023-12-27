class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if (!stk.isEmpty() && stk.peek() != '*') {
                stk.pop();
                }
            }
            else{
                stk.push(ch);
            }
            
        }

        StringBuilder ans = new StringBuilder();
        while(!stk.isEmpty()){
            ans.append(stk.pop());
        }
        return ans.reverse().toString();
    }
}
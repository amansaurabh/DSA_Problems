class Solution {
    static String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }

        generateCombinations(digits, 0, "", res);
        return res;
    }


    private void generateCombinations(String digits, int index, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String letters = codes[digit - '0'];

        for (char letter : letters.toCharArray()) {
            generateCombinations(digits, index + 1, current + letter, result);
        }
    }
}
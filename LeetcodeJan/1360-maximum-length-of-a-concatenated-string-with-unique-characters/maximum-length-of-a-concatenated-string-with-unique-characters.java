public class Solution {
    private Map<String, Integer> mp = new HashMap<>();

    private boolean hasCommon(String s1, String s2) {
        int[] arr = new int[26];

        for (char ch : s1.toCharArray()) {
            if (arr[ch - 'a'] > 0) {
                return true;
            }
            arr[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            if (arr[ch - 'a'] > 0) {
                return true;
            }
        }

        return false;
    }

    private int solve(int idx, List<String> arr, String temp, int n) {
        if (idx >= n) {
            return temp.length();
        }

        if (mp.containsKey(temp)) {
            return mp.get(temp);
        }

        int include = 0;
        int exclude = 0;
        if (hasCommon(arr.get(idx), temp)) {
            exclude = solve(idx + 1, arr, temp, n);
        } else {
            exclude = solve(idx + 1, arr, temp, n);
            temp += arr.get(idx);
            include = solve(idx + 1, arr, temp, n);
        }

        mp.put(temp, Math.max(include, exclude));
        return mp.get(temp);
    }

    public int maxLength(List<String> arr) {
        String temp = "";
        mp.clear();
        int n = arr.size();

        return solve(0, arr, temp, n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> arr = List.of("un", "iq", "ue");
        System.out.println(solution.maxLength(arr)); // Output: 4
    }
}
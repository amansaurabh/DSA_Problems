class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }
     private static void backtrack(List<String> result, String s, int index, String current, int segments) {
        if (segments == 4) {
            if (index == s.length()) {
                result.add(current);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }

            String segment = s.substring(index, index + i);
            if (isValidSegment(segment)) {
                String newCurrent = segments == 0 ? segment : current + "." + segment;
                backtrack(result, s, index + i, newCurrent, segments + 1);
            }
        }
    }

    private static boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
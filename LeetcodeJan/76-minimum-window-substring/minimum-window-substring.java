class Solution {
    public String minWindow(String s, String t) {
         int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        
        int requiredCount = t.length();
        int i = 0, j  = 0;
        int minStart  = 0;
        int minWindow = Integer.MAX_VALUE;
        
        while (j < n) {
            char ch_j = s.charAt(j);
            if (mp.containsKey(ch_j) && mp.get(ch_j) > 0)
                requiredCount--;
            
            mp.put(ch_j, mp.getOrDefault(ch_j, 0) - 1);
            
            while (requiredCount == 0) { // try to shrink the window
                if (minWindow > j - i + 1) {
                    minWindow = j - i + 1;
                    minStart  = i;
                }
                
                char ch_i = s.charAt(i);
                if (mp.containsKey(ch_i)) {
                    mp.put(ch_i, mp.getOrDefault(ch_i, 0) + 1);
                    if (mp.get(ch_i) > 0)
                        requiredCount++;
                }
                i++;
            }
            
            j++; // Don't ever forget this :-)
        }
        
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minWindow);

    }
}
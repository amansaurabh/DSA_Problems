class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> mp = new HashMap<>();
        for(String str : words){
            for(char ch : str.toCharArray()){
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            }
        }

        int n = words.length;

        for(int count : mp.values()){
            if(count % n != 0){
                return false;
            }
        }
        return true;
    }
}
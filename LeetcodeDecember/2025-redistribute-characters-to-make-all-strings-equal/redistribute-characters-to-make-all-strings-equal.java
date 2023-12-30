class Solution {
    public boolean makeEqual(String[] words) {
        // Map<Character, Integer> mp = new HashMap<>();
        // for(String str : words){
        //     for(char ch : str.toCharArray()){
        //         mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        //     }
        // }

        // int n = words.length;

        // for(int count : mp.values()){
        //     if(count % n != 0){
        //         return false;
        //     }
        // }
        // return true;


        // Using array instead of map

        int n = words.length;
        int[] charCount = new int[26]; 

        // for (String word : words) {
        //     for (char ch : word.toCharArray()) {
        //         charCount[ch - 'a']++;
        //     }
        // }

        // Using Lambda we can convert by

         Arrays.stream(words)
                .flatMapToInt(String::chars)
                .forEach(ch -> charCount[ch - 'a']++);

        // for (int count : charCount) {
        //     if (count % n != 0) {
        //         return false;
        //     }
        // }

        // Using Lambda we can convert by

        return Arrays.stream(charCount).allMatch(c -> c % n ==0);
        // return true;

    }
}
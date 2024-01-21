class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        
        int[] freq = new int[26];
        
        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }
        int sum = 0;
        int size = 0;
        int count = 1;
        
        Arrays.sort(freq);
        
        // Reverse the array to process frequencies in descending order
        for (int i = 0; i < freq.length / 2; i++) {
            int temp = freq[i];
            freq[i] = freq[freq.length - i - 1];
            freq[freq.length - i - 1] = temp;
        }
        
//         for(int val : freq){
//             if(val == 0) continue;
//             sum += val * round;
//             times++;
            
//             if (times >= 8 && round == 1) round++;
//             if (times >= 16 && round == 2) round++;
//             if (times >= 24 && round == 3) round++;
//         }
        
        for (int i = 0; i < 26; i++) {
        if (freq[i] == 0) continue;
        size++;
        sum += (freq[i] * count);
        if (size % 8 == 0) {
            count++;
        }
    }

        return sum;
    }
}
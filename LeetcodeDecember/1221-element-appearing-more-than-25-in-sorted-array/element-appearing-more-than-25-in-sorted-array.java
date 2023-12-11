class Solution {
    public int findSpecialInteger(int[] arr) {

        // Approach 1: 
        int freq = arr.length / 4;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > freq){
                return entry.getKey();
            }
        }

        return -1;

        //--------------------- Approach 2: O(n)-----------------------
        // int n = arr.length;
        // int freq = n / 4;

        // if(n == 1){
        //     return arr[0];
        // }

        // for(int i = 0; i < n - freq; i++){
        //     if(arr[i] == arr[i + freq]){
        //         return arr[i];
        //     }
        // }
        // return -1;
    }
}
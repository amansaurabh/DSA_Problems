class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int freq = n / 4;

        if(n == 1){
            return arr[0];
        }

        for(int i = 0; i < n - freq; i++){
            if(arr[i] == arr[i + freq]){
                return arr[i];
            }
        }
        return -1;
    }
}
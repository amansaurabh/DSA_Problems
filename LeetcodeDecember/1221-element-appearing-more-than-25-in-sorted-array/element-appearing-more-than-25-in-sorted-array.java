class Solution {
    public int findSpecialInteger(int[] arr) {

        //------------------- Approach 1: TC: O(n) AND SC: O(n)-------------------------
        // int freq = arr.length / 4;

        // Map<Integer, Integer> freqMap = new HashMap<>();

        // for(int num : arr){
        //     freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        // }

        // for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
        //     if(entry.getValue() > freq){
        //         return entry.getKey();
        //     }
        // }

        // return -1;

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

        //--------------------- Approach 3: Using Binary Search: O(logn)-----------------------
        // This approach 3 is discussed by CodestorywithMIK youtube channel

        // TC: of findSpecialInteger() is O(1), as it involves checking only three indices regardless of the array size.
        // TC: of firstOccur and lastOccur is O(logn)
        // Hence overall TC is O(logn)

        int n = arr.length;

        int freq = n / 4;

        List<Integer> candidates = Arrays.asList(arr[n / 4], arr[n / 2], arr[3 * n / 4]);

        for (int candidate : candidates) {
            int left = firstOccur(candidate, 0, n - 1, arr);
            int right = lastOccur(candidate, 0, n - 1, arr);

            if (right - left + 1 > freq) {
                return candidate;
            }
        }

        return -1;
    }
     private int firstOccur(int target, int l, int r, int[] arr) {
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                result = mid;
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
    // Binary search to find the last occurrence of an element in the array
    private int lastOccur(int target, int l, int r, int[] arr) {
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                result = mid;
                l = mid + 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
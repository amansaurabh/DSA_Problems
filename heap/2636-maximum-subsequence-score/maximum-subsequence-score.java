class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++)
            arr[i] = new int[] {nums1[i], nums2[i]};

        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

        long ans = 0, sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
        heap.offer(arr[i][0]);
        sum += arr[i][0];

        if (i > k - 1)
            sum -= heap.poll();
        
        if (i >= k-1)
            ans = Math.max(ans, sum * arr[i][1]);
        }
        return ans;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && temperatures[i] > temperatures[pq.peek()]) {
                int idx = pq.poll();
                ans[idx] = i - idx;
            }
            pq.offer(i);
        }
        return ans;
    }
}
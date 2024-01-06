class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // int n = startTime.length;
        // int[][] jobs = new int[n][3];
        // for (int i = 0; i < n; i++) {
        //     jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        // }
        // Arrays.sort(jobs, (a, b)->a[1] - b[1]);
        // TreeMap<Integer, Integer> dp = new TreeMap<>();
        // dp.put(0, 0);
        // for (int[] job : jobs) {
        //     int cur = dp.floorEntry(job[0]).getValue() + job[2];
        //     if (cur > dp.lastEntry().getValue())
        //         dp.put(job[1], cur);
        // }
        // return dp.lastEntry().getValue();

        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int currProfit = jobs[i - 1][2];
            int prevIdx = binarySearch(jobs, i - 1);

            dp[i] = Math.max(currProfit + dp[prevIdx + 1], dp[i - 1]);
        }

        return dp[n];
    }

    private int binarySearch(int[][] jobs, int i) {
        int low = 0, high = i - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][1] <= jobs[i][0]) {
                if (jobs[mid + 1][1] <= jobs[i][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
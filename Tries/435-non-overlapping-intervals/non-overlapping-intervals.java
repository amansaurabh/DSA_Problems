class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1])); // Sort intervals based on ending points
        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) { // If the current interval overlaps with the previous one
                count++; // Increment count as we need to remove an interval
            } else {
                end = intervals[i][1]; // Update the ending point
            }
        }

        return count;
    }
}
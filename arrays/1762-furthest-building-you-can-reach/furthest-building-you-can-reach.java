class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        // Using MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {

            if (heights[i + 1] <= heights[i]) {
                continue;
            }

            int diff = heights[i + 1] - heights[i];
            bricks -= diff;
            pq.offer(diff);

            if(bricks < 0){
                bricks += pq.poll();
                if(ladders > 0){
                    ladders--;
                }else{
                    return i;
                }
            }
        }
        return n - 1;
        // return solve(0, heights, bricks, ladders);
    }

    // ----------- It will give TLE ---------------

    // private int solve(int i, int[] heights, int bricks, int ladders){
    // if(i == n - 1){
    // return 0;
    // }

    // if(heights[i + 1] <= heights[i]){
    // return 1 + solve(i + 1, heights, bricks, ladders);
    // }
    // else{
    // int byBricks = 0;
    // int byLadder = 0;

    // if(bricks >= heights[i + 1] - heights[i]){
    // byBricks = 1 + solve(i + 1, heights, bricks - (heights[i + 1] - heights[i]),
    // ladders);
    // }
    // if (ladders > 0){
    // byLadder = 1 + solve(i + 1, heights, bricks, ladders - 1);
    // }
    // return Math.max(byBricks, byLadder);
    // }
    // }
}
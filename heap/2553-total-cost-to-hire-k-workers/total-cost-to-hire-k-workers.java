class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        // -----------------Wrong Approach ------------------------
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // for(int i : costs){
        //     maxHeap.add(i);
        //     if(maxHeap.size() > k){
        //         maxHeap.poll();
        //     }
        // }

        // long sum = 0;
        // while(!maxHeap.isEmpty()){
        //     sum += maxHeap.poll();
        // }
        // return sum;
        // --------------------Wrong Approach ------------------------


        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>();
        int i = 0;
        int j = n - 1;
        
        long ans = 0;

        while(k-- > 0){
            while(maxHeap1.size() < candidates && i <= j){
                maxHeap1.offer(costs[i++]);
            }

            while(maxHeap2.size() < candidates && i <= j){
                maxHeap2.offer(costs[j--]);
            }

            int val1 = maxHeap1.size() > 0 ? maxHeap1.peek() : Integer.MAX_VALUE;
            int val2 = maxHeap2.size() > 0 ? maxHeap2.peek() : Integer.MAX_VALUE;

            if(val1 > val2){
                ans += maxHeap2.poll();
            }else{
                ans += maxHeap1.poll();
            }
        }
        return ans;
    }
}
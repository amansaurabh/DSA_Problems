class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        } 

        for(int[] time : times){
            int source = time[0];
            int target = time[1];
            int weight = time[2];
            graph.get(source).add(new int[]{target, weight});
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];

            if(dist > distances[node]) continue;

            for(int[] neighbor : graph.get(node)){
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = dist + weight;
                if(newDist < distances[nextNode]){
                    distances[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
        // Find the maximum distance
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1; // Some nodes are not reachable
            }
            maxTime = Math.max(maxTime, distances[i]);
        }

        return maxTime;
    }
}
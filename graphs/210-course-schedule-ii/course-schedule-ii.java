class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
        }

        int[] indegree = new int[numCourses];
        for(int u = 0; u < numCourses; u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
                count++;
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int u = q.poll();
            ans[idx++] = u;

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.offer(v);
                    count++;
                }
            }
        }

        return  count == numCourses ? ans : new int[0];
    }
}
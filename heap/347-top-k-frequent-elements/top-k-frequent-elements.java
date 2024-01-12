class Pair{
    int num;
    int freq;
    Pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Compute the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        
        int[] ans = new int[k];

        for(int i = 0; i < k; i++){
            Pair current = maxHeap.poll();
            ans[i] = current.num;
        }
        return ans;
    }
}
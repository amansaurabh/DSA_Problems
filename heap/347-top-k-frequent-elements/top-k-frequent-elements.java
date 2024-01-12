// class Pair{
//     int num;
//     int freq;
//     Pair(int num, int freq){
//         this.num = num;
//         this.freq = freq;
//     }
// }

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {

//         Map<Integer, Integer> frequencyMap = new HashMap<>();

//         // Compute the frequency of each element
//         for (int num : nums) {
//             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//         }

//         PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

//         for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//             maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
//         }

//         int[] ans = new int[k];

//         for(int i = 0; i < k; i++){
//             Pair current = maxHeap.poll();
//             ans[i] = current.num;
//         }
//         return ans;
//     }
// }



// ----------------- using bucket sort ---------------------------------

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Compute the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use an array of lists as buckets
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        // Step 3: Iterate through buckets in reverse order to get the top k frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        // Convert the result list to an array
        int[] topKFrequentElements = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequentElements[i] = result.get(i);
        }

        return topKFrequentElements;
    }
}



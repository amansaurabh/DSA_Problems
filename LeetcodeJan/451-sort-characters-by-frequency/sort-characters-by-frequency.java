class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> (freq.get(b) - freq.get(a)));
	    heap.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
            char c = heap.poll();
            for(int i = 0; i < freq.get(c); i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int el : arr){
            if(map.containsKey(el)){
                map.put(el, map.get(el) + 1);
            }
            else{
                map.put(el, map.getOrDefault(el, 0) + 1);
            }
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
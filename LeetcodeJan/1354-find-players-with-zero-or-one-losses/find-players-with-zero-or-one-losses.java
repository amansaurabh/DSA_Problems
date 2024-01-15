class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;

        Map<Integer, Integer> lost = new HashMap<>();

        for(int i = 0; i < n; i++){
            lost.put(matches[i][1], lost.getOrDefault(matches[i][1], 0) + 1);
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int winner = matches[i][0];
            int loser = matches[i][1];

            if(!lost.containsKey(winner)){
                notLost.add(winner);
                lost.put(winner, 2);
            }

            if(lost.get(loser) == 1){
                oneLost.add(loser);
            }  
        }

        Collections.sort(notLost);
        Collections.sort(oneLost);

        List<List<Integer>> result = new ArrayList<>();
        result.add(notLost);
        result.add(oneLost);

        return result;
    }
}
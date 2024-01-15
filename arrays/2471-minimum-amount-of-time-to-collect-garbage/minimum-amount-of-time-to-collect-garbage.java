class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {

        int n = garbage.length;
        int G = 0;
        int M = 0;
        int P = 0;

        int totalTime = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < garbage[i].length(); j++){
                if(garbage[i].charAt(j) == 'M'){
                    M = i;
                } else if(garbage[i].charAt(j) == 'G'){
                    G = i;
                } else {
                    P = i;
                }
                totalTime++;
            }
        }

        for(int i = 1; i < travel.length; i++){
            travel[i] += travel[i - 1];
        }

        totalTime += M > 0 ? travel[M - 1] : 0;
        totalTime += G > 0 ? travel[G - 1] : 0;
        totalTime += P > 0 ? travel[P - 1] : 0;

        return totalTime;
    }
}
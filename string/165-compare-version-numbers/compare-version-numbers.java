class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Array = version1.split("\\.");
        String[] v2Array = version2.split("\\.");

        int n = Math.max(v1Array.length, v2Array.length);

        for(int i = 0; i < n; i++){
            int v1 = (i < v1Array.length) ? Integer.parseInt(v1Array[i]) : 0;
            int v2 = (i < v2Array.length) ? Integer.parseInt(v2Array[i]) : 0;

            if(v1 < v2){
                return -1;
            } else if(v1 > v2){
                return 1;
            }
        }
        return 0;
    }
}
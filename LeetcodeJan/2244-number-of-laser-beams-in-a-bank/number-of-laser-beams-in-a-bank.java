class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;

        int prevDeviceCount = 0;
        int res = 0;

        for(int i = 0; i < n; i++){
            int currDeviceCount = 0;
            for(char ch : bank[i].toCharArray()){
                if(ch == '1'){
                    currDeviceCount++;
                }
            }
            res += (currDeviceCount * prevDeviceCount);
            if(currDeviceCount != 0){
                prevDeviceCount = currDeviceCount;
            }
        }
        return res;
    }
}
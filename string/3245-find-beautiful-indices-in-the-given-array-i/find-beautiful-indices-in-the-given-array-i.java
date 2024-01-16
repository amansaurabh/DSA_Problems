class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
         List<Integer> i_index = new ArrayList<>();
         List<Integer> j_index = new ArrayList<>();
        
        
        i_index = KMP(s, a);
        j_index = KMP(s, b);
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < i_index.size(); i++){
            for(int j = 0; j < j_index.size(); j++){
                int absDiff = Math.abs(i_index.get(i) - j_index.get(j));
                if(absDiff <= k){
                    result.add(i_index.get(i));
                    break;
                }
            }
        }
        
        Collections.sort(result);
        return result;
    }
    
    private List<Integer> KMP(String str, String pat){
        int N = str.length();
        int M = pat.length();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(M == 0 || N == 0){
            return ans;
        }
        
        int[] lps = computeLPS(pat);
        
        int i = 0;
        int j = 0;
        
        while(i < N){
            if(str.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == M){
                ans.add(i - j);
                j = lps[j - 1];
            }else if(i < N && str.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }
        return ans;
    }
    
    private int[] computeLPS(String pat){
        int M = pat.length();
        int[] lps = new int[M];
        
        int len = 0;
        int i = 1;
        
        while(i < M){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1]; 
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
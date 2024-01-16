import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> i_indices = KMP(s, a);
        List<Integer> j_indices = KMP(s, b);
        
        List<Integer> result = new ArrayList<>();
        
        //it's O(n2)

        // for(int i = 0; i < i_index.size(); i++){
        //     for(int j = 0; j < j_index.size(); j++){
        //         int absDiff = Math.abs(i_index.get(i) - j_index.get(j));
        //         if(absDiff <= k){
        //             result.add(i_index.get(i));
        //             break;
        //         }
        //     }
        // }

        // better method to do the same
        // when will open |16 - j| <= k 
        // then wil be become 16 - j <= k and 16 - j >= -k
        // so we have to check these condition only

        for (int i : i_indices) {
            /*
             * For every index i where 'a' was found in 's' I will see if we find any index
             * j in the range i-k and i+k
             */

            int left_limit = Math.max(0, i - k); // To avoid out of bound -> I used max(0, i-k)
            int right_limit = Math.min(s.length() - 1, i + k); // To avoid out of bound -> I used min(n-1, i+k)

            int lowerBoundIndex = lowerBound(j_indices, left_limit);

            if (lowerBoundIndex < j_indices.size() && j_indices.get(lowerBoundIndex) <= right_limit) {
                result.add(i);
            }
        }

        return result;
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, result = list.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

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
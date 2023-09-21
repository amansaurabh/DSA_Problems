//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
         List<Integer> nums = new ArrayList<>();
        for (int num : arr) {
            nums.add(num);
        }

        int i = N - 2;
        
        // Find the pivot point
        while (i >= 0 && nums.get(i) >= nums.get(i + 1)) {
            i--;
        }
        
        if (i >= 0) {
            int j = N - 1;
            // Find the rightmost successor to the pivot
            while (nums.get(j) <= nums.get(i)) {
                j--;
            }
            Collections.swap(nums, i, j);
        }
        
        reverse(nums, i + 1);
        
        return nums;
    }
    static void reverse(List<Integer> nums, int start) {
        int i = start, j = nums.size() - 1;
        while (i < j) {
            Collections.swap(nums, i, j);
            i++;
            j--;
        }
    }
}
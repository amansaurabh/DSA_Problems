//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void multiply(ArrayList<Integer> arr, int size, int mul){
        int carry = 0;
        
        for(int i = 0; i < size; i++){
            int res = mul * arr.get(i);
            res = res + carry;
            arr.set(i, res%10);
            carry = res/10;
        }
        // carry > 10
        while(carry > 0){
            arr.add(carry%10);
            size++;
            carry = carry / 10;
        }
    }
    
    static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> arr = new ArrayList<>();
        
        arr.add(1);
        int size = 1;
        
        for(int mul = 2; mul <= N; mul++){
            multiply(arr, size, mul);
             size = arr.size();
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = size - 1; i >= 0; i--){
            ans.add(arr.get(i));
        }
        return ans;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        // int[] freq = new int[10];
        // solve(root, freq);
        // return count;

        // -------- Another method using Bit -----------
        solve(root, 0);
        return count;
    }

    // private void solve(TreeNode root, int[] temp){
    //     if(root != null){
    //         temp[root.val]++;

    //         if(root.left == null && root.right == null){
    //             int oddFreq = 0;
    //             for(int i = 1; i < 10; i++){
    //                 if(temp[i] % 2 != 0){
    //                     oddFreq++;
    //                 }
    //             }
    //             count += oddFreq <= 1? 1 : 0;
    //         }
    //         solve(root.left, temp);
    //         solve(root.right, temp);

    //         temp[root.val]--;
    //     }
    // }


    private void solve(TreeNode root, int temp){
        if(root != null){
            temp = temp ^ (1 << root.val);

            if(root.left == null && root.right == null){
                if((temp & (temp - 1)) == 0){
                    count++;
                }
            }
            solve(root.left, temp);
            solve(root.right, temp);
        }
    }
}
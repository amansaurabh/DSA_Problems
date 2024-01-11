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


// --------------------- Two Pass solution -----------------------

// class Solution {
//     int maxDiff = -1;
//     void findMaxUtil(TreeNode root, TreeNode child){
//         if(root == null || child == null){
//             return;
//         }
//         maxDiff = Math.max(maxDiff, Math.abs(root.val - child.val));

//         findMaxUtil(root, child.left);
//         findMaxUtil(root, child.right);

//     }

//     void findMaxDiff(TreeNode root){
//         if(root == null) return;

//         findMaxUtil(root, root.left);
//         findMaxUtil(root, root.right);

//         findMaxDiff(root.left);
//         findMaxDiff(root.right);

//     } 

//     public int maxAncestorDiff(TreeNode root) {

//         findMaxDiff(root);
//         return maxDiff;
//     }
// }


// --------------------- One Pass Solution -----------------------

class Solution{
    private int dfs(TreeNode root, int mx, int mn){
        if(root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mx, mn), dfs(root.right, mx, mn));
    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}
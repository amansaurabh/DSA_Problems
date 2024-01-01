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
    int maxZigZag = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root.left, 1, true);
        dfs(root.right, 1, false);

        return maxZigZag;
    }
    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) {
            maxZigZag = Math.max(maxZigZag, length - 1);
            return;
        }

        if (isLeft) {
            dfs(node.right, length + 1, false); // Move right
            dfs(node.left, 1, true); // Reset count and change direction to left
        } else {
            dfs(node.left, length + 1, true); // Move left
            dfs(node.right, 1, false); // Reset count and change direction to right
        }
    }
}
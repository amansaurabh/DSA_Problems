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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
     private int countGoodNodes(TreeNode node, int maxValue) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxValue) {
            count++;
            maxValue = node.val;
        }

        count += countGoodNodes(node.left, maxValue);
        count += countGoodNodes(node.right, maxValue);

        return count;
    }
}
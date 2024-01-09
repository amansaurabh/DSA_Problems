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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leafSequence1 = new StringBuilder();
        StringBuilder leafSequence2 = new StringBuilder();

        collectLeafNodes(root1, leafSequence1);
        collectLeafNodes(root2, leafSequence2);

        return leafSequence1.toString().equals(leafSequence2.toString());
    }
    
    private void collectLeafNodes(TreeNode node, StringBuilder sequence) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sequence.append(node.val).append(",");
        }

        collectLeafNodes(node.left, sequence);
        collectLeafNodes(node.right, sequence);
    }
}
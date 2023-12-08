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
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        result.append(root.val);

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        // If both left and right are empty, don't include empty parentheses
        if (left.equals("") && right.equals("")) {
            return result.toString();
        }

        result.append("(").append(left).append(")");

        // Only add the right subtree if it's not empty
        if (!right.equals("")) {
            result.append("(").append(right).append(")");
        }

        return result.toString();
    }
}
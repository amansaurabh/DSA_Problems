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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        int level = 0;

        while(!q.isEmpty()){
            level++;
            int size = q.size();
            int sum = 0;

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
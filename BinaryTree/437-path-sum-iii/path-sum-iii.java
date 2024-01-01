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
    int count = 0;
    long target;
    long csum = 0;

    public int pathSum(TreeNode root, int targetSum) {
         HashMap<Long, Integer> hm = new HashMap<>();
        hm.put((long)0, 1);
        if(root == null) return count;
        target = targetSum;
        dfs(root,hm);
        return count;
    }

    private void dfs(TreeNode node , HashMap<Long, Integer> hm ){
        csum += node.val;
        if(hm.containsKey(csum - target)){
            count += hm.get(csum - target);
        }
        hm.put(csum, hm.getOrDefault(csum, 0) + 1);

        if(node.left != null){
            dfs(node.left ,hm);
        }
        if(node.right != null){
            dfs(node.right,hm);
        }   
        if(hm.containsKey(csum)){
            if(hm.get(csum) ==1 ){
                hm.remove(csum);
            }else{
                hm.put(csum , hm.get(csum)-1);
            }
        }
        csum -= node.val;
        return;
    }
}
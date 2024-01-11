/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// -------------------- Two pass Solution ---------------------------------
// class Solution {
//     private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

//     public int amountOfTime(TreeNode root, int start) {
//         convertToGraph(root);
//         Deque<Integer> queue = new ArrayDeque<>();
//         Set<Integer> visited = new HashSet<>();
      
//         queue.offer(start);
//         int time = -1; 
      
//         while (!queue.isEmpty()) {
//             time++;
//             for (int i = queue.size(); i > 0; i--) {
//                 int currentNode = queue.pollFirst();
//                 visited.add(currentNode);
              
//                 if (adjacencyList.containsKey(currentNode)) {
//                     for (int neighbor : adjacencyList.get(currentNode)) {
//                         if (!visited.contains(neighbor)) {
//                             queue.offer(neighbor);
//                         }
//                     }
//                 }
//             }
//         }
//         return time;
//     }

//      private void convertToGraph(TreeNode node) {
//         if (node == null) {
//             return;
//         }
      
//         if (node.left != null) {
//             adjacencyList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
//             adjacencyList.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
//         }
      
//         if (node.right != null) {
//             adjacencyList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
//             adjacencyList.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
//         }
      
        
//         convertToGraph(node.left);
//         convertToGraph(node.right);
//     }
// }


// -------------------- One pass Solution ---------------------------------

class Solution{
    int res = Integer.MIN_VALUE;

    private int solve(TreeNode root, int start){
        if(root == null){
            return 0;
        }

        int Left = solve(root.left, start);
        int Right = solve(root.right, start);

        if(root.val == start){
            res = Math.max(Left, Right);
            return -1;
        }else if(Left >= 0 && Right >= 0){
            int max = Math.max(Left, Right) + 1;
            return max;
        }else{
            int sum = Math.abs(Left) + Math.abs(Right);
            res = Math.max(res, sum);
            return Math.min(Left, Right) - 1;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        solve(root, start);
        return res;
    }
}
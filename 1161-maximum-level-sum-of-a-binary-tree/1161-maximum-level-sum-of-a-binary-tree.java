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

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            int currentSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                currentSum += cur.val;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = level;
            }
            
            level++;
        }
        return maxLevel;
    }
}
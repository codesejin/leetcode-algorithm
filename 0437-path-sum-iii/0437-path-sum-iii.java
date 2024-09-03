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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 현재 노드 기준으로 탐색하기
        dfs(root, targetSum);

        // 왼쪽노드
        pathSum(root.left, targetSum);
		// 오른쪽노드
        pathSum(root.right, targetSum);

        return count;
    }

    private void dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return;
        }
        
        currentSum -= node.val;

        if (currentSum == 0) {
            count++;
        }

        // 왼쪽
        dfs(node.left, currentSum);
		// 오른쪽
        dfs(node.right, currentSum);
    }
}
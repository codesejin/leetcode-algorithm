/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 최소 공통 조상 = 트리 T에서 두 노드가 자손으로 있는 가장 가까운 부모 노드
    // 두 노드가 트리내 서로 다른 위치에 있을때, 두 노드가 공통으로 속하는 가장 가까윈 상위노드 찾기
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 현재 node값이 p이거나 q일경우, 혹은 null일 경우 -> 찾았음
       // System.out.println(">>> 현재 노드 root : " + (root != null ? root.val : null));

        if (root == null || root == p || root == q) {
            return root;
        }
        // 왼쪽과 오른쪽 서브트리에서 각각 LCA를 찾음
        TreeNode left = lowestCommonAncestor(root.left, p, q);
     //   System.out.println("left : " + (left != null ? left.val : null));
        TreeNode right = lowestCommonAncestor(root.right, p, q);
      //  System.out.println("right : " + (right != null ? right.val : null));

        //System.out.println(">>> 재귀 순환 끝!!! ");
        // 만약 왼쪽과 오른쪽 서브트리에서 모두 노드를 찾은 경우, 현재 노드가 LCA임
        // root가 두 노드의 공통 조상일 때 의미
        if (left != null && right != null) {
           // System.out.println("둘다 Null이 아닐때 root : " + (root != null ? root.val : null));
            return root;
        }
        TreeNode rr = left != null ? left : right;
       // System.out.println("한쪽만 Null일때 : " + (rr != null ? rr.val : null));
        // 한쪽 서브트리에서만 찾은 경우 그 노드를 반환
        return rr;
    }
}
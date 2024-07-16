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
// 이차원 배열 하나 요소 당 루트노드, 자식노드, 왼쪽여부
// 왼쪽 여부 : 1 일 경우, 부모의 왼쪽 자식 노드
// 오른쪽 여부 : 0 일 경우, 부모의 오른쪽 자식 노드
// 이진트리를 생성하고 루트를 반환해라
class Solution {
public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            int isLeft = description[2];
            
            TreeNode parentNode = map.getOrDefault(parentVal, new TreeNode(parentVal));
            map.put(parentVal, parentNode);
            
            TreeNode childNode = map.getOrDefault(childVal, new TreeNode(childVal));
            map.put(childVal, childNode);
            
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            children.add(childVal);
        }
        
        for (int[] description : descriptions) {
            if (!children.contains(description[0])) {
                return map.get(description[0]);
            }
        }
        
        return null;
    }
}
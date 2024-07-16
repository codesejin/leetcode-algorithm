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
        // 노드 값을 키로 하고 TreeNode 객체를 값으로 하는 맵
        Map<Integer, TreeNode> map = new HashMap<>();
        // 자식 노드 값을 저장하는 집합
        Set<Integer> children = new HashSet<>();

        // 각 관계를 처리하여 트리를 구성
        for (int[] description : descriptions) {
            int parentVal = description[0];  // 부모 노드 값
            int childVal = description[1];   // 자식 노드 값
            int isLeft = description[2];     // 왼쪽 자식인지 여부 (1이면 왼쪽, 0이면 오른쪽)

            // 부모 노드를 맵에서 가져오거나 새로 생성
            TreeNode parentNode = map.getOrDefault(parentVal, new TreeNode(parentVal));
            map.put(parentVal, parentNode);

            // 자식 노드를 맵에서 가져오거나 새로 생성
            TreeNode childNode = map.getOrDefault(childVal, new TreeNode(childVal));
            map.put(childVal, childNode);

            // 부모와 자식 노드를 연결
            if (isLeft == 1) {
                parentNode.left = childNode;  // 왼쪽 자식 노드로 설정
            } else {
                parentNode.right = childNode; // 오른쪽 자식 노드로 설정
            }

            // 자식 노드 값을 집합에 추가
            children.add(childVal);
        }

        // 루트 노드는 자식 노드 셋에 없는 부모 노드
        for (int[] description : descriptions) {
            if (!children.contains(description[0])) {
                return map.get(description[0]);  // 루트 노드를 반환
            }
        }

        return null;  // 모든 노드가 자식 노드인 경우, 루트 노드가 없음
    }
}
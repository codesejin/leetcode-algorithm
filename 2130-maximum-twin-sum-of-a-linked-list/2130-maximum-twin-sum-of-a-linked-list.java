/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // 연결리스트 사이즈는 짝수
    // i번째 노드(0-indexed)는 (n-1-i)번째 노드의 쌍
    // 최대 쌍합 반환하기
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        int maxTwinSum = 0;
        // 연결리스트 길이 구하기
        int linkedListSize = 1;
        ListNode node = head;
        while (node.next != null) {
            linkedListSize++;
            node = node.next;
        }
        // Stack에 절반만 집어넣고, 절반 이후부터는 꺼내면서 계산하기
        int halfSize = linkedListSize/2;
        node = head;
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < linkedListSize; i++) {
            int cur = node.val;
            if (i < halfSize) {
                st.push(cur);
                node = node.next;
            } else {
                int poppedInt = (!st.isEmpty()) ? st.pop() : 0;
                int currentInt = cur;
                maxTwinSum = Math.max(maxTwinSum, poppedInt+currentInt);
                node = node.next;
            }
        }
        return maxTwinSum;
    }
}
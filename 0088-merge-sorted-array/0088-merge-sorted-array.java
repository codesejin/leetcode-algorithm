class Solution {
    // 오름차순 정렬되어있음
    // 정수는 요소의 개수 -> m이나 n만큼 사용
    // 단일배열로 만든건 nums1에 저장되어야 함
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < m; i++) {
            pq.add(nums1[i]);
        }

        for (int i = 0; i < n; i++) {
            pq.add(nums2[i]);
        }

        int index = 0;
        while (!pq.isEmpty()) {
            nums1[index++] = pq.poll();
        }
    }
}
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0];
            int cy = queries[i][1];
            int r = queries[i][2];
            int cnt = 0; // 각 쿼리마다 cnt 변수 초기화

            for (int j = 0; j < points.length; j++) {
                int px = points[j][0];
                int py = points[j][1];
                
                // 점 (px, py)가 원 (cx, cy, r) 내부에 있는지 확인
                double distance = Math.sqrt(Math.pow(px - cx, 2) + Math.pow(py - cy, 2));
                if (distance <= r) {
                    cnt++;
                }
            }
            answer[i] = cnt; // 결과 저장
        }

        return answer;
    }
}

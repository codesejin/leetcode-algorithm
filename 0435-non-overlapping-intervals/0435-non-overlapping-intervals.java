class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // intervals 배열을 간격의 끝점(end)을 기준으로 정렬합니다.
        // 예를 들어, [[1,2], [2,3], [3,4], [1,3]]이면 [[1,2], [2,3], [3,4], [1,3]]으로 정렬됩니다.
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // 첫 번째 간격의 끝점을 end 변수에 저장합니다. 예를 들어, [[1,2], [2,3], [3,4], [1,3]]이면 end = 2입니다.
        int end = intervals[0][1];

        // count 변수는 유효한 간격(겹치지 않는 간격)의 수를 저장합니다. 최소한 하나의 간격은 포함되므로 1로 초기화합니다.
        int count = 1;

        // 두 번째 간격부터 반복문을 실행합니다.
        for (int i = 1; i < intervals.length; i++) {
            // 현재 간격의 시작점이 이전 간격의 끝점보다 크거나 같다면, 이 간격은 겹치지 않는 유효한 간격입니다.
            // 예를 들어, end = 2이고 intervals[i] = [3, 4]라면 count를 1 증가시킵니다.
            if (intervals[i][0] >= end) {
                count++;
                // 다음 반복을 위해 end를 현재 간격의 끝점으로 업데이트합니다.
                end = intervals[i][1];
            }
        }

        // intervals.length에서 count(유효한 간격의 수)를 뺀 값이 제거해야 하는 최소 간격의 수입니다.
        return intervals.length - count;
    }
}
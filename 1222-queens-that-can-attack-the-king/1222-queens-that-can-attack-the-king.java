class Solution {
    static int[][] board;
    static List<Integer> oneCoordinates;

    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1}; // 아래, 위, 오른쪽, 왼쪽, 대각선 동남쪽, 대각선 남서쪽, 대각선 서북쪽, 대각선 북동쪽
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1}; // 아래, 위, 오른쪽, 왼쪽, 대각선 동남쪽, 대각선 남서쪽, 대각선 서북쪽, 대각선 북동쪽

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        board = new int[8][8];

        // 보드에 퀸의 좌표 넣기
        for (int i = 0; i < queens.length; i++) {
            int x = queens[i][0];
            int y = queens[i][1];
            board[x][y] = 1;
        }

        // 8방 탐색 - 왕의 위치에서부터 시작
        for (int i = 0; i < 8; i++) {
            int x = king[0];
            int y = king[1];

            while (validateIndex(x, y)) {
                x += dx[i];
                y += dy[i];

                if (validateIndex(x, y) && board[x][y] == 1) {
                    result.add(Arrays.asList(x, y));
                    break;
                }
            }
        }

        return result;
    }

    private boolean validateIndex(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}

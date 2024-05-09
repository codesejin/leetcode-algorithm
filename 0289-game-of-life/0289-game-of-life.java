class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    static  int[] dy = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    static int N, M;
    static int sum;
    static int[][] grid;
    public void gameOfLife(int[][] board) {

        N = board.length;
        M = board[0].length;

        grid = new int[board.length][board[0].length];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cur = grid[i][j];
                sum = 0;
                int cnt = countNeighbors(i, j);
               // System.out.println(">> i + j : " + i  + " " + j);
               // System.out.println(">> sum : " + sum);
                //  2개 미만의 살아있는 이웃을 가진 살아있는 세포는 죽는다.  -> 인구 부족
                if (cur == 1 && cnt < 2) {
                    board[i][j] = 0;
                }
                // 2개 혹은 3개의 살아있는 이웃을 가진 살아있는 세포는 산다 -> 다음 세대까지
                if (cur == 1 && cnt == 2) {
                    board[i][j] = 1;
                }
                if (cur == 1 && cnt == 3) {
                    board[i][j] = 1;
                }
                // 3개 이상 살아있는 이웃을 가진 살아있는 세포는 죽는다 -> 인구 과잉
                if (cur == 1 && cnt > 3) {
                    board[i][j] = 0;
                }

                // 정확히 3개가 살아있는 인구를 가진 죽은 세포는 살아있는 세포가 된다 -> 재탄생
                if (cur == 0 && cnt == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countNeighbors(int x, int y) {

        for (int i = 0; i < 8 ; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                if (grid[newX][newY] > 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
class Solution {
    // 1 : 땅
    // 0 : 물
    // 연결되어있지 않은 땅의 개수 반환
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 땅이면서 방문하지 않은 경우에만 DFS 수행
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y, char[][] grid) {
        grid[x][y] = 0;
        // 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // 경계값 확인 및 방문 여부와 땅인 경우만 재귀 호출
            if (validateIndex(newX, newY, grid.length, grid[0].length) 
                && grid[newX][newY] == '1') {
                dfs(newX, newY, grid);
            }
        }
    }

    // 배열의 인덱스가 유효한지 확인하는 메서드
    private boolean validateIndex(int newX, int newY, int rowLen, int colLen) {
        return newX >= 0 && newX < rowLen && newY >= 0 && newY < colLen;
    }
}
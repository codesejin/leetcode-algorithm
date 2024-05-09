class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int N = matrix.length, M = matrix[0].length;
        int x = 0, y = 0;
        boolean[][] visited = new boolean[N][M];
        result.add(matrix[x][y]); // 초기화
        visited[x][y] = true;
        while (total --> 0) {

            // 오른쪽으로 이동
            while (y + 1 < M && !visited[x][y + 1]) {
                y++;
                visited[x][y] = true;
                result.add(matrix[x][y]);
            }
            // 아래로 이동
            while (x + 1 < N && !visited[x + 1][y]) {
                x ++;
                visited[x][y] = true;
                result.add(matrix[x][y]);
            }
            // 왼쪽으로 이동
            while (y - 1 >= 0 && !visited[x][y-1]) {
                y--;
                visited[x][y] = true;
                result.add(matrix[x][y]);
            }
            // 위로 이동
            while (x - 1 >= 0 && !visited[x-1][y]) {
                x--;
                visited[x][y] = true;
                result.add(matrix[x][y]);
            }
        }
        return result;

    }
}
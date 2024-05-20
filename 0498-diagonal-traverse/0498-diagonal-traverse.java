class Solution {
 public int[] findDiagonalOrder(int[][] mat) {

        int xLen = mat.length, yLen = mat[0].length;
        int[] output = new int[xLen * yLen];
        int x = 0, y = 0, idx = 0;

        while (idx < xLen * yLen) {
            // 우상향 대각선
            while (x >= 0 && y < yLen) {
                output[idx++] = mat[x][y];
                x--; y++;
            }

            // 좌하향 대각선 시작점 조정
            if (y == yLen) { // y 끝에 도달했을 때
                x += 2; y--;
            } else {
                x++;
            }

            // 좌하향 대각선
            while (x < xLen && y >= 0) {
                output[idx++] = mat[x][y];
                x++; y--;
            }

            // 우상향 대각선 시작점 조정
            if (x == xLen) { // x 끝ㅔ 도달했을 떄
                y += 2; x--;
            } else {
                y++;
            }
        }

        return output;
    }
}
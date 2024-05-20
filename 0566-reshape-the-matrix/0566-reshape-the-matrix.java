class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;        // 원래 행렬의 행 수
        int n = mat[0].length;     // 원래 행렬의 열 수

        // 원소 수가 맞지 않으면 원래 행렬 반환
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        System.out.println(Arrays.deepToString(result));

        for (int i = 0; i < m * n; i++) {
            result[i / c][i % c] = mat[i / n][i % n];
        }

        return result;
    }
}
class Solution {
    public int equalPairs(int[][] grid) {

        List<int[]> rowList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            rowList.add(grid[i]);
        }

        List<int[]> colList = new ArrayList<>();
        for (int i = 0; i < grid[0].length; i++) {
            int[] colArray = new int[grid[0].length];
            for (int j = 0; j < grid.length; j++) {
                colArray[j] = grid[j][i];
            }
            colList.add(colArray);
        }

        int count = 0;
        for (int[] row : rowList) {
            for (int[] col : colList) {
                if (Arrays.equals(row, col)) {
                    count++;
                }
            }
        }

        return count;
    }
}
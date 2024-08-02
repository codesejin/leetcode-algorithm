class Solution {
    public int equalPairs(int[][] grid) {
     
        List<int[]> rowList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            rowList.add(row);
        }
        
        List<int[]> colList = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            int[] col = new int[grid.length];
            for (int i = 0; i < grid.length; i++) {
                col[i] = grid[i][j];
            }
            colList.add(col);
        }
        
        int count = 0;
        for (int[] row : rowList) {
            for (int[] col : colList) {
                if (areEqual(row, col)) {
                    count++;
                }
            }
        }

        return count;
    }
    
    private boolean areEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
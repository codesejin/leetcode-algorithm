class Solution {
   // static List<Coordinate> list;
    
    
    public int oddCells(int m, int n, int[][] indices) {
        int[][] twoDArray = new int[m][n];
        
       // list = new ArrayList<>();
        
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.putIfAbsent("X", new ArrayList<>());
        map.putIfAbsent("Y", new ArrayList<>());

        for (int i = 0; i < indices.length; i++) {
            int x = indices[i][0];
            int y = indices[i][1];
            map.get("X").add(x);
            map.get("Y").add(y);
        }
        // x측 - row측 증가시키기
        for (Integer x : map.get("X")) {
          for (int i = 0; i < n; i++) {
              twoDArray[x][i] += 1;
          }
        }
        
        // y측 - column측 증가시키기
        for (Integer y : map.get("Y")) {
          for (int i = 0; i < m; i++) {
              twoDArray[i][y] += 1;
          }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j % 2 != 0) {
                    result += twoDArray[i][j];
                }
            }
        }
        return (int)Arrays.stream(twoDArray).flatMapToInt(Arrays::stream).filter(num -> num % 2 != 0).count();
    }
}
class Solution {
    // 선호도 배열이 있어. n명의 친구들 위한
    // n은 항상 짝수야
    // 목록의 앞에있는 친구가 뒤에 친구보다 더 선호되는 친구임
    // 각 목록의 친구들은 0부터 n-1까지의 정수로 표시됨
    // 모든 친구들은 쌍으로 나뉘어짐 -> 쌍은 pairs로 주어짐
    // pairs[i] = [xi, yi] 는  xi가 yi와 쌍을 이루고 yi가 xi와 쌍을 이룬다는 것을 나타냄
    
    // 이 짝짓기는 일부 친구들을 불행하게 만듬
    // 친구 x가 y와 짝을 이루고 있는데, 친구 u가 v와 짝을 이루고 있고 다음 조건을 만족하는 경우, 친구 x는 불행함
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // 각 친구의 현재 쌍을 저장하는 배열
        int[] pairings = new int[n];
        for (int[] pair : pairs) {
            pairings[pair[0]] = pair[1];
            pairings[pair[1]] = pair[0];
        }
        System.out.println(" pairs : " + Arrays.toString(pairings));
        // 선호도 순위를 저장하는 2차원 배열
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }
        System.out.println(" rank : " + Arrays.deepToString(rank));

        int unhappyCount = 0;

        // 각 친구가 불행한지 확인
        for (int x = 0; x < n; x++) {
            int y = pairings[x];
            for (int i = 0; i < rank[x][y]; i++) {
                int u = preferences[x][i];
                int v = pairings[u];
                if (rank[u][x] < rank[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }

        return unhappyCount;
    }
    
    // 예제 1  -> 왜 순서가 있을까?
    // 0 : 1, 2, 3  
    // 1 : 3, 2, 0 -- unhappy
    // 2 : 3, 1, 0
    // 3 : 1, 2, 0 -- unhappy
    
    // 예제3
    // 0 : 1, 3, 2  -- unhappy
    // 1 : 2, 3, 0  -- unhappy
    // 2 : 1, 3, 0  -- unhappy
    // 3 : 0, 2, 1  -- unhappy
    
    // wrong answer 예제 -> 목록별 순서가 같으면 불행하지 않나보군
    // 0 : 1, 3, 2 
    // 1 : 2, 3, 0 
    // 2 : 1, 0, 3 
    // 3 : 1, 0, 2 
    // 짝 매칭 [[2,1],[3,0]]
    
    // wrong answer 예제 -> 목록별 순서가 같으면 불행하지 않나보군 - 아니군
    // 0 : 1, 3, 2 
    // 1 : 2, 3, 0 
    // 2 : 1, 3, 0 
    // 3 : 0, 2, 1 
    // 짝 매칭 [[1,3],[0,2]]
}
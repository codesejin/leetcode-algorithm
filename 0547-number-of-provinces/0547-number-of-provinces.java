class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;  // 도시의 수
        boolean[] visited = new boolean[n];  // 각 도시의 방문 여부
        int provinceCount = 0;  // 프로빈스 개수
        
        // 각 도시를 순회
        for (int i = 0; i < n; i++) {
            // 방문하지 않은 도시라면 DFS를 실행하여 연결된 도시들을 모두 방문 처리
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinceCount++;  // 하나의 프로빈스를 찾았으므로 개수 증가
            }
        }
        
        return provinceCount;  // 총 프로빈스 개수 반환
    }
    
    // DFS를 통해 연결된 모든 도시를 방문 처리
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;  // 현재 도시를 방문 처리
        
        for (int j = 0; j < isConnected.length; j++) {
            // 현재 도시가 다른 도시와 연결되어 있고, 그 도시가 아직 방문되지 않았다면 DFS 재귀 호출
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}

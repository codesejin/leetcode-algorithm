import java.util.*;

class Solution {
    // connections[i] = [ai, bi] --> 도시 ai에서 도시 bi로 가는 도로
    // 임무 : 모든 도시에서 도시 0으로 이동할 수 있도록 도로의 방향을 재조정
    // 도로의 방향을 변경해야 하는 최소 횟수를 반환
    public int minReorder(int n, int[][] connections) {
        // 인접 리스트 생성. 각 도시와 그 도시에 연결된 도로를 저장
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        // 도로의 방향을 기록. 도로가 0을 향하는 경우 1, 반대는 0
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>())
                .add(Arrays.asList(connection[1], 1)); // 방향이 설정된 도로
            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>())
                .add(Arrays.asList(connection[0], 0)); // 반대 방향으로 가는 도로
        }
        

        // BFS 탐색을 별도 메소드로 호출
        return bfs(0, n, adj);
    }

    // BFS 탐색 메소드
    private int bfs(int startCity, int n, Map<Integer, List<List<Integer>>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        // 도시 0부터 시작
        queue.offer(startCity);
        // 방문한 도시를 추적하는 배열
        boolean[] visited = new boolean[n];
        visited[startCity] = true;
        int changeCount = 0;

        // BFS 실행
        while (!queue.isEmpty()) {
            int city = queue.poll();

            // 연결된 도시들 탐색
            for (List<Integer> neighbor : adj.get(city)) {
                int nextCity = neighbor.get(0);
                int direction = neighbor.get(1);
                
    //System.out.println("현재 도시: " + city + ", 연결된 도시: " + nextCity + ", 방향: " + (direction == 1 ? "변경 필요" : "올바른 방향"));

                // 도시가 아직 방문되지 않았으면
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                    // 방향이 1이면 도로를 변경해야 함
                    if (direction == 1) {
                        changeCount++;
                        System.out.println("도로의 방향을 변경해야 합니다: " + city + " -> " + nextCity);
                    } else {
                        System.out.println("이미 올바른 방향: " + nextCity + " -> " + city);
                    }
                }
            }
        }

        // 변경된 도로 수 반환
        return changeCount;
    }
}
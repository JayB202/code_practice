import java.util.*;

public class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프를 인접 리스트 형태로 표현
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 정보를 그래프에 추가
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // BFS를 위한 큐와 거리 배열 초기화
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // 거리 배열을 -1로 초기화 (미방문 상태)
        
        // 1번 노드부터 시작
        queue.add(1);
        distance[1] = 0;
        
        // BFS 수행
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (distance[neighbor] == -1) { // 아직 방문하지 않은 노드
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        // 가장 먼 거리 찾기
        int maxDistance = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
            }
        }
        
        // 가장 먼 노드의 개수 세기
        int count = 0;
        for (int dist : distance) {
            if (dist == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}

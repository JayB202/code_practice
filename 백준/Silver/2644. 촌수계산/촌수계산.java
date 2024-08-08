import java.util.*;

public class Main {
    static List<Integer>[] graph;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // 전체 사람의 수
        int start = scanner.nextInt(); // 촌수를 계산할 첫 번째 사람
        int end = scanner.nextInt(); // 촌수를 계산할 두 번째 사람
        int m = scanner.nextInt(); // 부모 자식 관계의 개수
        
        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 부모 자식 관계 입력 처리
        for (int i = 0; i < m; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            graph[parent].add(child);
            graph[child].add(parent); // 부모-자식 관계는 양방향
        }
        
        // BFS를 이용한 촌수 계산
        int result = bfs(start, end, n);
        System.out.println(result);
        
        scanner.close();
    }
    
    static int bfs(int start, int end, int n) {
        // 촌수를 기록할 배열
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // 초기화: -1은 방문하지 않았음을 의미
        
        // 큐를 이용한 BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // 현재 노드와 연결된 모든 노드를 탐색
            for (int neighbor : graph[current]) {
                if (distance[neighbor] == -1) { // 방문하지 않은 노드
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                    
                    // 목표 노드를 찾으면 촌수를 반환
                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }
        
        // 두 사람 간의 촌수를 찾을 수 없는 경우
        return -1;
    }
}

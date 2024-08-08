import java.util.*;

public class Main {
    
    // 인접 리스트를 저장할 벡터
    private static final int MAX_NODES = 50001;
    private static List<Integer>[] adj = new ArrayList[MAX_NODES];
    private static int[] visit = new int[MAX_NODES];
    
    // BFS를 통해 그래프가 이분 그래프인지 확인
    private static boolean bfs(int start) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(start, 1)); // 시작 노드와 색상 1
        
        visit[start] = 1;
        
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            int cur = current.getKey();
            int color = current.getValue();
            
            for (int next : adj[cur]) {
                if (visit[next] == 0) {
                    // 색상이 다른 경우에만 방문
                    int nextColor = (color == 1) ? 2 : 1;
                    visit[next] = nextColor;
                    queue.add(new Pair<>(next, nextColor));
                } else if (visit[next] == color) {
                    // 색상이 같으면 이분 그래프가 아님
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 노드 수
        int e = sc.nextInt(); // 엣지 수
        
        // 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // 엣지 정보 입력
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        
        boolean isBipartite = true;
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                isBipartite = bfs(i);
                if (!isBipartite) {
                    break;
                }
            }
        }
        
        if (isBipartite) {
            long cnt1 = 0;
            long cnt2 = 0;
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 1) {
                    cnt1++;
                } else if (visit[i] == 2) {
                    cnt2++;
                }
            }
            long result = cnt1 * cnt2 * 2; // 노란색 개수 * 초록색 개수 * 2
            System.out.println(result);
        } else {
            System.out.println(0);
        }
        
        sc.close();
    }
    
    // Pair 클래스 정의 (Java에서는 내장 Pair가 없기 때문에 직접 정의 필요)
    private static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}

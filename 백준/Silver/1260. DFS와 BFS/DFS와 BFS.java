import java.util.*;

public class Main {
    static int N, M, V; // 노드 개수, 간선 개수, 시작 노드
    static int[][] graph; // 인접 행렬
    static boolean[] visitedDfs; // DFS 방문 체크
    static boolean[] visitedBfs; // BFS 방문 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        // 인접 행렬 초기화
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1; // 양방향 간선
        }

        // 방문 배열 초기화
        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];

        // DFS 실행 (재귀)
        //System.out.print("DFS (재귀): ");
        dfsRecursive(V);
        System.out.println();

        // DFS 실행 (스택 사용)
        //System.out.print("DFS (스택): ");
        //List<Integer> dfsResult = dfsStack(V);
        //for (int node : dfsResult) {
        //   System.out.print(node + " ");
        //}
        //System.out.println();

        // BFS 실행
        //System.out.print("BFS: ");
        List<Integer> bfsResult = bfs(V);
        for (int node : bfsResult) {
            System.out.print(node + " ");
        }
    }

    // DFS (재귀)
    static void dfsRecursive(int node) {
        visitedDfs[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visitedDfs[i]) {
                dfsRecursive(i);
            }
        }
    }

    // DFS (스택 사용)
    static List<Integer> dfsStack(int start) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N + 1]; // 독립적인 방문 체크 배열
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                result.add(node);

                // 연결된 노드를 큰 번호부터 스택에 추가
                for (int i = N; i >= 1; i--) {
                    if (graph[node][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        return result;
    }

    // BFS (큐 사용)
    static List<Integer> bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N + 1]; // 독립적인 방문 체크 배열
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // 연결된 노드를 작은 번호부터 큐에 추가
            for (int i = 1; i <= N; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }
}

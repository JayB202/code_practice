import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean[] inStack;
    static boolean hasCycle = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            int M = sc.nextInt();
            for (int j = 0; j < M; j++) {
                int destination = sc.nextInt();
                graph.get(i).add(destination);
            }
        }

        visited = new boolean[N + 1];
        inStack = new boolean[N + 1];

        // Start DFS from node 1
        dfs(1);

        if (hasCycle) {
            System.out.println("CYCLE");
        } else {
            System.out.println("NO CYCLE");
        }
    }

    private static void dfs(int node) {
        if (hasCycle) return;

        visited[node] = true;
        inStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (inStack[neighbor]) {
                hasCycle = true;
                return;
            }
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }

        inStack[node] = false;
    }
}

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        long value;
        Node(int idx, long value) {
            this.idx = idx;
            this.value = value;
        }
    }

    static long answer = Integer.MIN_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        bfs(N);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int N) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        queue.offer(new Node(1, 0));

        while (!queue.isEmpty()) {
            boolean flag = false;
            Node cur = queue.poll();
            for (Node nxt : graph.get(cur.idx)) {
                if (!visited[nxt.idx]) {
                    flag = true;
                    visited[nxt.idx] = true;
                    queue.offer(new Node(nxt.idx, cur.value + nxt.value));
                }
            }
            if (!flag) answer = Math.max(answer, cur.value);
        }
    }
}

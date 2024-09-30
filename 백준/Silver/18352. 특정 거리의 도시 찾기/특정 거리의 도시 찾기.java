import java.io.*;
import java.util.*;

/*
1. 입력
도시의 개수 N, 도로의 개수 M, 거리 K, 출발 도시 번호 X
... M개 줄 동안
A에서 B 도시 사이에 단방향 도로가 존재한다는 의미

2. 출력
X로부터 출발하여 도달할 수 있는 도시 중 최단거리가 K인 모든 도시
오름차순 출력, 없으면 -1 출력

3. 문제 접근법
최단거리를 구하는 문제기 때문에 BFS로 해결
각 도시와 간선을 리스트에 저장

 */
public class Main {
    static List<List<Integer>> graph;
    static int[] result;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);    // a도시에서 b도시 간선 추가
        }

        result = new int[n + 1];
        Arrays.fill(result, -1);    // -1로 방문횟수 초기화
        result[x] = 0; // 출발도시 거리 추가

        bfs(x); // bfs 호출

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (result[i] == k) {
                bw.write(i + "\n");
                found = true;
            }
        }
        if (!found) bw.write("-1");
        bw.flush();
        bw.close();
    }
		
    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int city = queue.poll();   // 현재 도시
            // 현재 도시와 연결된 모든 도시 확인하기
            for (int nextCity : graph.get(city)) {
                if(result[nextCity] == -1){ // 방문하지 않은 도시일 때
                    result[nextCity] = result[city] + 1;    // 거리 갱신
                    queue.add(nextCity);    // 큐에 추가
                }
            }
        }
    }
}

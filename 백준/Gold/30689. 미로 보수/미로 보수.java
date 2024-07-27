import java.util.*;

public class Main {
    static int N, M;
    static String[] arr;
    static int[][] visited;
    static int[][] done;
    static int[][] cost;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int answer = 0;
    static Map<Character, Integer> m = new HashMap<>();

    static void dfs(int py, int px) {
        visited[py][px] = 1;
        int dir = m.get(arr[py].charAt(px));
        int y = dy[dir] + py;
        int x = dx[dir] + px;
        if (x < 0 || y < 0 || x >= M || y >= N) {
            // out
            done[py][px] = 1;
            return;
        }
        if (done[y][x] == 1) {
            done[py][px] = 1;
            return;
        } else if (visited[y][x] == 1) {
            int sy = y;
            int sx = x;
            int cc = Integer.MAX_VALUE;
            do {
                cc = Math.min(cc, cost[sy][sx]);
                int d = m.get(arr[sy].charAt(sx));
                sy = dy[d] + sy;
                sx = dx[d] + sx;
            } while (sy != y || sx != x);
            answer += cc;
        } else {
            dfs(y, x);
        }
        done[py][px] = 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m.put('U', 1);
        m.put('D', 0);
        m.put('L', 3);
        m.put('R', 2);

        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        arr = new String[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = scanner.nextLine();
        }

        cost = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                cost[i][j] = scanner.nextInt();
            }
            if (i < N - 1) {
                scanner.nextLine(); // Consume newline character after each row
            }
        }

        visited = new int[N][M];
        done = new int[N][M];
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (done[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        
        System.out.println(answer);
    }
}

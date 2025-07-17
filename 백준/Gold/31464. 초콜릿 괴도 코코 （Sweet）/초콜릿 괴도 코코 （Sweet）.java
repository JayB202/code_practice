import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean inBounds(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static int countComponents(char[][] map) {
        boolean[][] visited = new boolean[N][N];
        int count = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == '#' && !visited[r][c]) {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cr = cur[0], cc = cur[1];
                        for (int dir = 0; dir < 4; dir++) {
                            int nr = cr + dx[dir];
                            int nc = cc + dy[dir];
                            if (inBounds(nr, nc) && map[nr][nc] == '#' && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    static boolean allEdgesAreBridges(char[][] map) {
        List<int[]> nodes = new ArrayList<>();
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
                if (map[r][c] == '#')
                    nodes.add(new int[]{r, c});

        int nodeCount = nodes.size();

        // 간선 집합: (작은 좌표, 큰 좌표) 형태로 저장
        Set<String> edgeSet = new HashSet<>();
        for (int[] node : nodes) {
            int r = node[0], c = node[1];
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dx[dir];
                int nc = c + dy[dir];
                if (inBounds(nr, nc) && map[nr][nc] == '#') {
                    int r1 = r, c1 = c, r2 = nr, c2 = nc;
                    // 정렬해서 저장
                    if (r1 > r2 || (r1 == r2 && c1 > c2)) {
                        int tmpR = r1, tmpC = c1;
                        r1 = r2; c1 = c2;
                        r2 = tmpR; c2 = tmpC;
                    }
                    edgeSet.add(r1 + "," + c1 + "-" + r2 + "," + c2);
                }
            }
        }

        int edgeCount = edgeSet.size();
        if (edgeCount != nodeCount - 1)
            return false;

        Set<String> visited = new HashSet<>();

        // DFS 방문
        voidDfs:
        {
            Deque<int[]> stack = new ArrayDeque<>();
            int[] start = nodes.get(0);
            stack.push(start);
            visited.add(start[0] + "," + start[1]);

            while (!stack.isEmpty()) {
                int[] cur = stack.pop();
                int cr = cur[0], cc = cur[1];
                for (int dir = 0; dir < 4; dir++) {
                    int nr = cr + dx[dir];
                    int nc = cc + dy[dir];
                    String key = nr + "," + nc;
                    if (inBounds(nr, nc) && map[nr][nc] == '#' && !visited.contains(key)) {
                        visited.add(key);
                        stack.push(new int[]{nr, nc});
                    }
                }
            }
        }

        return visited.size() == nodeCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            grid[i] = line.toCharArray();
        }

        List<int[]> results = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == '#') {
                    grid[r][c] = '.';
                    if (countComponents(grid) == 1 && allEdgesAreBridges(grid)) {
                        results.add(new int[]{r + 1, c + 1});
                    }
                    grid[r][c] = '#';
                }
            }
        }

        results.sort((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

        System.out.println(results.size());
        for (int[] res : results) {
            System.out.println(res[0] + " " + res[1]);
        }
    }
}

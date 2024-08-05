import java.util.*;

class Main {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int years = 0;
        while (true) {
            // 1. 빙산의 덩어리 수를 계산
            int chunks = countChunks();
            if (chunks >= 2) {
                // 빙산이 두 덩어리 이상으로 분리되었으면 현재 연도를 반환
                System.out.println(years);
                return;
            }

            // 2. 빙산 해빙 시뮬레이션
            meltIcebergs();

            // 3. 모든 빙산이 녹았는지 확인
            boolean hasIce = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        hasIce = true;
                        break;
                    }
                }
                if (hasIce) break;
            }
            if (!hasIce) {
                // 모든 빙산이 녹았으면 0을 반환
                System.out.println(0);
                return;
            }

            years++;
        }
    }

    // 빙산의 덩어리 수를 계산하는 함수
    private static int countChunks() {
        visited = new boolean[N][M];
        int chunks = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    chunks++;
                }
            }
        }

        return chunks;
    }

    // BFS를 이용하여 연결된 빙산을 탐색
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            for (int[] dir : directions) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY] && map[newX][newY] > 0) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }

    // 빙산 해빙 시뮬레이션 함수
    private static void meltIcebergs() {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int seaCount = 0;
                    for (int[] dir : directions) {
                        int newX = i + dir[0];
                        int newY = j + dir[1];

                        if (newX >= 0 && newX < N && newY >= 0 && newY < M && map[newX][newY] == 0) {
                            seaCount++;
                        }
                    }
                    newMap[i][j] = Math.max(0, map[i][j] - seaCount);
                }
            }
        }

        map = newMap;
    }
}

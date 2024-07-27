import java.util.*;

public class Main {
    static int N, M; // 미로의 세로(N)와 가로(M) 크기
    static String[] arr; // 미로의 각 칸에 있는 방향 정보
    static int[][] visited; // DFS 탐색 중 방문 여부를 저장하는 배열
    static int[][] done; // 사이클 탐색 후 처리가 완료된 칸을 저장하는 배열
    static int[][] cost; // 각 칸에 점프대를 설치하는 비용을 저장하는 배열
    static int[] dy = {1, -1, 0, 0}; // 방향에 따른 세로 이동 값 (하, 상, 좌, 우)
    static int[] dx = {0, 0, 1, -1}; // 방향에 따른 가로 이동 값 (하, 상, 좌, 우)
    static int answer = 0; // 사이클을 탈출하는데 필요한 최소 비용
    static Map<Character, Integer> m = new HashMap<>(); // 방향 문자와 방향 인덱스 간의 매핑

    // DFS를 사용하여 사이클을 탐색하고 최소 비용을 계산하는 함수
    static void dfs(int py, int px) {
        visited[py][px] = 1; // 현재 칸 방문 표시
        int dir = m.get(arr[py].charAt(px)); // 현재 칸의 방향을 인덱스로 변환
        int y = dy[dir] + py; // 방향에 따라 이동할 세로 위치
        int x = dx[dir] + px; // 방향에 따라 이동할 가로 위치

        // 미로의 경계를 벗어난 경우 (탈출)
        if (x < 0 || y < 0 || x >= M || y >= N) {
            done[py][px] = 1; // 현재 칸에서 탈출 가능
            return;
        }

        // 현재 위치에서 이동할 다음 위치가 이미 처리된 경우
        if (done[y][x] == 1) {
            done[py][px] = 1; // 현재 칸 처리 완료
            return;
        } else if (visited[y][x] == 1) {
            // 사이클을 발견한 경우
            int sy = y; // 사이클 시작 위치의 세로 좌표
            int sx = x; // 사이클 시작 위치의 가로 좌표
            int cc = Integer.MAX_VALUE; // 사이클의 최소 비용을 저장할 변수

            // 사이클을 탐색하여 최소 비용을 계산
            do {
                cc = Math.min(cc, cost[sy][sx]); // 사이클 내의 최소 비용을 찾음
                int d = m.get(arr[sy].charAt(sx)); // 현재 위치의 방향을 인덱스로 변환
                sy = dy[d] + sy; // 다음 위치로 이동
                sx = dx[d] + sx;
            } while (sy != y || sx != x); // 사이클의 시작 위치로 돌아올 때까지 반복

            answer += cc; // 사이클의 최소 비용을 총 비용에 추가
        } else {
            dfs(y, x); // 다음 위치로 DFS를 계속 진행
        }

        done[py][px] = 1; // 현재 칸의 탐색 완료
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 방향 문자와 방향 인덱스 간의 매핑 설정
        m.put('U', 1); // 'U'는 상 방향 (인덱스 1)
        m.put('D', 0); // 'D'는 하 방향 (인덱스 0)
        m.put('L', 3); // 'L'은 좌 방향 (인덱스 3)
        m.put('R', 2); // 'R'은 우 방향 (인덱스 2)

        // 미로의 세로(N)와 가로(M) 크기 입력
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        // 미로의 방향 정보 입력
        arr = new String[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = scanner.nextLine(); // 각 행의 방향 정보를 입력받음
        }

        // 각 칸에 점프대를 설치하는 비용 입력
        cost = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                cost[i][j] = scanner.nextInt(); // 각 칸의 점프대 설치 비용을 입력받음
            }
            if (i < N - 1) {
                scanner.nextLine(); // 다음 행을 위한 개행 문자 처리
            }
        }

        // DFS를 위해 방문 배열과 처리 완료 배열을 초기화
        visited = new int[N][M];
        done = new int[N][M];
        
        // 미로의 모든 칸을 탐색
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (done[i][j] == 0) {
                    dfs(i, j); // 현재 칸에서 DFS를 시작
                }
            }
        }
        
        // 최소 비용 출력
        System.out.println(answer);
    }
}

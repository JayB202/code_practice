import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 방의 크기
    static int[][] room; // 방 상태
    static boolean[][] cleaned; // 청소된 칸
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서
    static int cleanedCount = 0; // 청소한 칸 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 방의 크기 입력
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        // 로봇 청소기의 초기 위치와 방향 입력
        String[] robotInfo = br.readLine().split(" ");
        int r = Integer.parseInt(robotInfo[0]);
        int c = Integer.parseInt(robotInfo[1]);
        int d = Integer.parseInt(robotInfo[2]);

        // 방의 상태 입력
        room = new int[N][M];
        cleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 청소기 작동 시작
        clean(r, c, d);
        
        // 청소한 칸 수 출력
        System.out.println(cleanedCount);
    }

    static void clean(int r, int c, int d) {
        if (!cleaned[r][c]) {
            cleaned[r][c] = true; // 현재 칸 청소
            cleanedCount++;
        }

        // 반시계 방향으로 회전하여 주변 칸 확인
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; // 반시계 방향 회전
            int nr = r + directions[d][0];
            int nc = c + directions[d][1];

            // 앞쪽 칸이 청소되지 않았고 벽이 아닐 경우
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0 && !cleaned[nr][nc]) {
                clean(nr, nc, d); // 전진하여 청소
                return;
            }
        }

        // 주변에 청소되지 않은 빈 칸이 없는 경우 후진
        int backDir = (d + 2) % 4; // 현재 방향의 반대 방향
        int backR = r + directions[backDir][0];
        int backC = c + directions[backDir][1];

        // 후진할 수 있으면 후진
        if (backR >= 0 && backR < N && backC >= 0 && backC < M && room[backR][backC] == 0) {
            clean(backR, backC, d); // 후진하여 청소
        }
    }
}

import java.util.Scanner;

public class Main {
    // 방향을 나타내는 배열 (오른쪽, 아래, 오른쪽 아래 대각선, 오른쪽 위 대각선)
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[19][19];

        // 바둑판 입력 받기
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 바둑판 검사
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) { // 바둑알이 있는 경우
                    int currentColor = board[i][j];
                    for (int d = 0; d < 4; d++) { // 4가지 방향 검사
                        if (checkWin(board, i, j, currentColor, d)) {
                            System.out.println(currentColor);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        // 승부가 결정되지 않은 경우
        System.out.println(0);
    }

    // 특정 방향으로 연속된 바둑알을 검사하는 함수
    public static boolean checkWin(int[][] board, int x, int y, int color, int direction) {
        int count = 1;

        int nx = x + dx[direction];
        int ny = y + dy[direction];

        // 연속된 바둑알 개수 세기
        while (isInBounds(nx, ny) && board[nx][ny] == color) {
            count++;
            nx += dx[direction];
            ny += dy[direction];
        }

        // 연속된 5개의 바둑알 확인
        if (count == 5) {
            // 6개 이상의 바둑알이 연속되는지 확인
            nx = x - dx[direction];
            ny = y - dy[direction];
            if (isInBounds(nx, ny) && board[nx][ny] == color) {
                return false;
            }

            nx = x + 5 * dx[direction];
            ny = y + 5 * dy[direction];
            if (isInBounds(nx, ny) && board[nx][ny] == color) {
                return false;
            }

            return true;
        }

        return false;
    }

    // 바둑판의 범위를 벗어나지 않는지 확인하는 함수
    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}

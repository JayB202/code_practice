import java.io.*;
import java.util.*;

public class Main {
    static int maxSum = 0;
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

    static class Fish {
        int x, y, dir;
        boolean alive;
        Fish(int x, int y, int dir, boolean alive) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.alive = alive;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[4][4];
        Fish[] fishes = new Fish[17]; // 1~16

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = num;
                fishes[num] = new Fish(i, j, dir, true);
            }
        }

        int startFish = board[0][0];
        Fish first = fishes[startFish];
        first.alive = false;
        board[0][0] = -1; // 상어

        dfs(board, fishes, 0, 0, first.dir, startFish);
        System.out.println(maxSum);
    }

    static void dfs(int[][] board, Fish[] fishes, int sx, int sy, int sd, int sum) {
        maxSum = Math.max(maxSum, sum);

        int[][] newBoard = copyBoard(board);
        Fish[] newFishes = copyFishes(fishes);

        moveFish(newBoard, newFishes, sx, sy);

        for (int step = 1; step <= 3; step++) {
            int nx = sx + dx[sd] * step;
            int ny = sy + dy[sd] * step;

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
            if (newBoard[nx][ny] == 0) continue;

            int[][] tempBoard = copyBoard(newBoard);
            Fish[] tempFishes = copyFishes(newFishes);

            int eatFish = tempBoard[nx][ny];
            tempBoard[sx][sy] = 0;
            tempBoard[nx][ny] = -1;
            tempFishes[eatFish].alive = false;

            dfs(tempBoard, tempFishes, nx, ny, tempFishes[eatFish].dir, sum + eatFish);
        }
    }

    static void moveFish(int[][] board, Fish[] fishes, int sx, int sy) {
        for (int i = 1; i <= 16; i++) {
            Fish f = fishes[i];
            if (!f.alive) continue;

            for (int d = 0; d < 8; d++) {
                int nd = (f.dir + d) % 8;
                int nx = f.x + dx[nd];
                int ny = f.y + dy[nd];

                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (nx == sx && ny == sy)) continue;

                if (board[nx][ny] != 0) {
                    int swapFish = board[nx][ny];
                    Fish temp = fishes[swapFish];
                    temp.x = f.x;
                    temp.y = f.y;
                    board[f.x][f.y] = swapFish;
                } else {
                    board[f.x][f.y] = 0;
                }

                board[nx][ny] = i;
                f.x = nx;
                f.y = ny;
                f.dir = nd;
                break;
            }
        }
    }

    static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; i++)
            copy[i] = board[i].clone();
        return copy;
    }

    static Fish[] copyFishes(Fish[] fishes) {
        Fish[] copy = new Fish[17];
        for (int i = 1; i <= 16; i++) {
            Fish f = fishes[i];
            if (f == null) continue;
            copy[i] = new Fish(f.x, f.y, f.dir, f.alive);
        }
        return copy;
    }
}

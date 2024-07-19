import java.util.Scanner;

public class Main {
    // dp 배열을 정의
    static final int MAX = 21; // 범위는 0~20
    static int[][][] dp = new int[MAX][MAX][MAX];

    // w(a, b, c) 값을 계산하는 함수
    static int w(int a, int b, int c) {
        // 기본 조건 처리
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        // 범위 초과 처리
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);

        // dp 배열이 비어있지 않은 경우, 저장된 값 반환
        if (dp[a][b][c] != 0) return dp[a][b][c];

        // 순서 조건
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            // 기타 경우
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == -1 && b == -1 && c == -1) break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }

        sc.close();
    }
}

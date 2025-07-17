import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 싸움 시간
        int M = Integer.parseInt(st.nextToken()); // B 스킬 시간

        int[] dp = new int[N + 1];
        dp[0] = 1; // 초기값

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1]; // A를 사용한 경우
            if (i >= M) {
                dp[i] = (dp[i] + dp[i - M]) % MOD; // B를 사용한 경우
            }
        }

        System.out.println(dp[N]);
    }
}

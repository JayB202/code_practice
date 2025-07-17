import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 조카 수
        int N = Integer.parseInt(st.nextToken()); // 과자 수

        long[] snacks = new long[N];
        st = new StringTokenizer(br.readLine());
        long maxLen = 0;
        for (int i = 0; i < N; i++) {
            snacks[i] = Long.parseLong(st.nextToken());
            maxLen = Math.max(maxLen, snacks[i]);
        }

        long left = 1, right = maxLen;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (long snack : snacks) {
                cnt += snack / mid;
            }

            if (cnt >= M) {
                answer = mid; // 가능한 경우, 더 큰 길이 시도
                left = mid + 1;
            } else {
                right = mid - 1; // 불가능하므로 길이 줄이기
            }
        }

        System.out.println(answer);
    }
}

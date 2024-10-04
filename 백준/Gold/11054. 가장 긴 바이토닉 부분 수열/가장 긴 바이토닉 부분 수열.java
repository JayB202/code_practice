import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] incr = new int[N];  // 증가하는 부분 수열의 길이
        int[] decr = new int[N];  // 감소하는 부분 수열의 길이
        
        // 증가하는 부분 수열 계산
        for (int i = 0; i < N; i++) {
            incr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && incr[i] < incr[j] + 1) {
                    incr[i] = incr[j] + 1;
                }
            }
        }
        
        // 감소하는 부분 수열 계산
        for (int i = N - 1; i >= 0; i--) {
            decr[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i] && decr[i] < decr[j] + 1) {
                    decr[i] = decr[j] + 1;
                }
            }
        }
        
        // 가장 긴 바이토닉 수열 길이 찾기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, incr[i] + decr[i] - 1);
        }
        
        System.out.println(maxLength);
    }
}

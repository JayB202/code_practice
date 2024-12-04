import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // A는 오름차순 정렬
        Arrays.sort(A);
        // B는 정렬하지 않고 최대값을 찾아가며 처리
        boolean[] used = new boolean[n];
        int S = 0;
        
        for (int i = 0; i < n; i++) {
            int maxB = Integer.MIN_VALUE;
            int maxIndex = -1;
            
            for (int j = 0; j < n; j++) {
                if (!used[j] && B[j] > maxB) {
                    maxB = B[j];
                    maxIndex = j;
                }
            }
            
            used[maxIndex] = true; // B의 값을 사용 처리
            S += A[i] * maxB;      // A의 작은 값과 B의 큰 값을 곱함
        }
        
        System.out.println(S);
    }
}

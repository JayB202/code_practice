import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        long T = sc.nextLong();  // 목표값 T
        int n = sc.nextInt();    // 배열 A의 크기
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int m = sc.nextInt();    // 배열 B의 크기
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        // 2. 배열 A의 모든 부 배열 합을 해시맵에 저장
        HashMap<Long, Integer> sumA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.put(sum, sumA.getOrDefault(sum, 0) + 1);
            }
        }

        // 3. 배열 B의 부 배열 합을 계산하며 A의 부 배열 합과 T를 만족하는 경우 찾기
        long resultCount = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                // 필요한 배열 A의 부 배열 합은 T - sum
                long target = T - sum;
                if (sumA.containsKey(target)) {
                    resultCount += sumA.get(target);
                }
            }
        }

        // 4. 결과 출력
        System.out.println(resultCount);
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력
        int n = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }
        
        // A는 오름차순 정렬
        Arrays.sort(A);
        // B는 내림차순 정렬
        Integer[] B_desc = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(B_desc, Collections.reverseOrder());
        
        // S 계산
        int S = 0;
        for (int i = 0; i < n; i++) {
            S += A[i] * B_desc[i];
        }
        
        // 결과 출력
        System.out.println(S);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 끊어진 줄 개수
        int M = sc.nextInt();  // 브랜드 개수
        
        int minPackage = Integer.MAX_VALUE;  // 최소 패키지 가격
        int minSingle = Integer.MAX_VALUE;   // 최소 낱개 가격
        
        // 각 브랜드의 패키지 가격과 낱개 가격을 입력받아 최소값 갱신
        for (int i = 0; i < M; i++) {
            int packagePrice = sc.nextInt();
            int singlePrice = sc.nextInt();
            
            if (packagePrice < minPackage) {
                minPackage = packagePrice;
            }
            if (singlePrice < minSingle) {
                minSingle = singlePrice;
            }
        }
        
        // 1. 패키지로만 살 경우
        int cost1 = (N / 6) * minPackage + (N % 6) * minSingle;
        
        // 2. 패키지와 낱개를 조합해서 살 경우
        int cost2 = ((N + 5) / 6) * minPackage; // (N + 5) / 6 은 올림 효과를 가져옴
        
        // 3. 전부 낱개로 살 경우
        int cost3 = N * minSingle;
        
        // 최소값 계산
        int result = Math.min(cost1, Math.min(cost2, cost3));
        
        System.out.println(result);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 값 받기
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        
        // 초기 배열의 크기: 2^N
        int size = (1 << N); // 2^N
        System.out.println(findZOrder(N, r, c, size));
    }
    
    // Z 모양 순서를 찾는 함수
    static int findZOrder(int N, int r, int c, int size) {
        // 기본 조건: 배열이 1x1일 때
        if (size == 1) return 0;
        
        int halfSize = size / 2;
        int quadrantSize = halfSize * halfSize;
        
        if (r < halfSize && c < halfSize) {
            // 1사분면
            return findZOrder(N - 1, r, c, halfSize);
        } else if (r < halfSize && c >= halfSize) {
            // 2사분면
            return quadrantSize + findZOrder(N - 1, r, c - halfSize, halfSize);
        } else if (r >= halfSize && c < halfSize) {
            // 3사분면
            return 2 * quadrantSize + findZOrder(N - 1, r - halfSize, c, halfSize);
        } else {
            // 4사분면
            return 3 * quadrantSize + findZOrder(N - 1, r - halfSize, c - halfSize, halfSize);
        }
    }
}

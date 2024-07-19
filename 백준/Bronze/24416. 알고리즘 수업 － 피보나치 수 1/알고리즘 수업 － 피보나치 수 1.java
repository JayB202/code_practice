import java.util.Scanner;

public class Main {

    static int recursiveCount = 0;
    static int dynamicCount = 0;

    // 재귀 호출로 피보나치 수를 계산
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recursiveCount++; // 코드1
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 동적 프로그래밍으로 피보나치 수를 계산
    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            dynamicCount++; // 코드2
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 재귀 호출 방식으로 피보나치 수 계산 (실행 횟수 카운트 포함)
        fib(n);

        // 동적 프로그래밍 방식으로 피보나치 수 계산 (실행 횟수 카운트 포함)
        fibonacci(n);

        // 결과 출력
        System.out.println(recursiveCount + " " + dynamicCount);
    }
}

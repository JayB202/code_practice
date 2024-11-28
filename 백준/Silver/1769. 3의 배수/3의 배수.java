import java.util.Scanner;

public class Main {
    // 합계 계산 함수
    public static int schedules(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0'; // 문자에서 정수로 변환하여 더함
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int count = 0;
        String X = sc.next().trim();

        // 합계 값 리턴 받기
        int total = schedules(X);
        count++;

        if (total < 10) {
            if (total % 3 == 0) {
                System.out.println(0);
                System.out.println("YES");
            } else {
                System.out.println(0);
                System.out.println("NO");
            }
        } else {
            // 한 자리 수가 될 때까지 반복
            while (total >= 10) { // 수정: total이 10 이상인 동안 반복
                total = schedules(Integer.toString(total));
                count++;
            }

            // 3의 배수 판단
            if (total == 0 || total % 3 == 0) {
                System.out.println(count);
                System.out.println("YES");
            } else {
                System.out.println(count);
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

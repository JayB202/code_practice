import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력받기
        String N = sc.nextLine();
        
        // 입력받은 숫자를 배열로 변환
        char[] digits = N.toCharArray();
        
        // 모든 숫자의 합 계산
        int sum = 0;
        boolean hasZero = false;
        
        for (char digit : digits) {
            sum += digit - '0';
            if (digit == '0') {
                hasZero = true;
            }
        }
        
        // 30의 배수 조건 확인
        if (sum % 3 == 0 && hasZero) {
            // 내림차순 정렬
            Arrays.sort(digits);
            
            // 가장 큰 수를 만들기 위해 뒤집어서 출력
            StringBuilder result = new StringBuilder(new String(digits));
            System.out.println(result.reverse().toString());
        } else {
            // 30의 배수를 만들 수 없으면 -1 출력
            System.out.println("-1");
        }
        
        sc.close();
    }
}

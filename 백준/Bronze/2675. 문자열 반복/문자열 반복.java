import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫 번째 줄에서 테스트 케이스의 개수를 읽습니다.
        int T = sc.nextInt();
        sc.nextLine(); // 개행 문자를 소비하여 다음 입력을 준비합니다.

        for (int i = 0; i < T; i++) {
            // 각 테스트 케이스를 읽습니다.
            int R = sc.nextInt();
            String S = sc.next();
            
            // 새로운 문자열 P를 저장할 StringBuilder를 초기화합니다.
            StringBuilder P = new StringBuilder();
            
            // 문자열 S의 각 문자를 R번 반복하여 P에 추가합니다.
            for (int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                for (int k = 0; k < R; k++) {
                    P.append(c);
                }
            }
            
            // 결과 문자열 P를 출력합니다.
            System.out.println(P.toString());
        }

        sc.close();
    }
}

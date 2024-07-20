import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine(); 
        
        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            String S = sc.next();
            
            StringBuilder P = new StringBuilder();
            
            // 문자열 S의 각 문자를 R번 반복하여 P에 추가
            for (int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                for (int k = 0; k < R; k++) {
                    P.append(c);
                }
            }
            
            System.out.println(P.toString());
        }

        sc.close();
    }
}

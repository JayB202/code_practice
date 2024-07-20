import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next().trim();
        
        // 부분 문자열의 고유 개수를 계산하여 출력
        System.out.println(countUniqueSubstrings(s));

        sc.close();
    }

    public static int countUniqueSubstrings(String s) {
        Set<String> uniqueSubstrings = new HashSet<>();

        // 모든 부분 문자열을 생성하여 집합에 추가
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                uniqueSubstrings.add(s.substring(i, j));
            }
        }

        // 서로 다른 부분 문자열의 개수를 반환
        return uniqueSubstrings.size();
    }
}

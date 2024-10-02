//1. 입력 : N 개 문자열 입력

//2-1. 접두사 길이 계산
//2-1-1. 두 문자열의 앞부분에서 공통으로 나타나는 부분 길이
//2-2. 유사도 계산 및 저장
//2-2-1. 가장 긴 접두사 길이 저장
//2-2-2. 현재 접두사 길이가 가장 긴 것보다 길다면, 현재 쌍과 접두사 길이를 저장

//3. 출력 : 가장 긴 접두사를 가진 두 문자열 출력 ( 두개 동일하면 x )

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문자열 개수 입력
        int N = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // 문자열 입력 받기
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = scanner.nextLine();
        }

        // 변수 초기화
        int maxPrefixLength = 0;
        String word1 = "";
        String word2 = "";

        // 모든 문자열 쌍에 대해 접두사 길이 계산
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int prefixLength = getPrefixLength(words[i], words[j]);
                if (prefixLength > maxPrefixLength) {
                    maxPrefixLength = prefixLength;
                    word1 = words[i];
                    word2 = words[j];
                }
            }
        }

        // 결과 출력
        System.out.println(word1);
        System.out.println(word2);

        scanner.close();
    }
    
    
    // 두 문자열의 접두사 길이 계산
    public static int getPrefixLength(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int length = 0;
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

}

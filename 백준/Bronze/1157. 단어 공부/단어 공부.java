import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        String word = sc.next().trim().toUpperCase();

        // 알파벳 빈도수를 저장할 배열 초기화
        int[] frequency = new int[26];  // A-Z에 대한 빈도수 배열

        // 알파벳 빈도수 계산
        for (char ch : word.toCharArray()) {
            int index = ch - 'A';
            frequency[index]++;
        }

        // 가장 높은 빈도수 찾기
        int maxCount = 0;
        for (int count : frequency) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // 가장 높은 빈도수를 가지는 알파벳 찾기
        int mostFrequentCount = 0;
        char mostFrequentChar = '?';
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == maxCount) {
                if (mostFrequentCount == 0) {
                    mostFrequentChar = (char) (i + 'A');
                    mostFrequentCount++;
                } else {
                    mostFrequentChar = '?';
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println(mostFrequentChar);

        sc.close();
    }
}

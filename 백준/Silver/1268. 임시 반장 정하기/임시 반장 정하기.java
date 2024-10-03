import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 학생 수 입력
        int studentCount = scanner.nextInt();
        // 반 정보를 저장할 2D 배열
        int[][] classes = new int[studentCount][5];

        // 반 정보 입력
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < 5; j++) {
                classes[i][j] = scanner.nextInt();
            }
        }

        // 각 학생과 같은 반이었던 학생 수를 계산하기 위한 배열
        int[] sameClassCount = new int[studentCount];

        // 학생 간의 비교
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < studentCount; j++) {
                if (i != j) { // 자신과 비교하지 않기
                    for (int grade = 0; grade < 5; grade++) {
                        if (classes[i][grade] == classes[j][grade]) {
                            sameClassCount[i]++;
                            break; // 같은 반인 경우 더 이상 확인할 필요 없음
                        }
                    }
                }
            }
        }

        // 최대 같은 반 학생 수 및 임시 반장 후보 찾기
        int maxCount = -1;
        int president = -1;

        for (int i = 0; i < studentCount; i++) {
            if (sameClassCount[i] > maxCount) {
                maxCount = sameClassCount[i];
                president = i + 1; // 학생 번호는 1부터 시작
            } else if (sameClassCount[i] == maxCount) {
                president = Math.min(president, i + 1); // 번호가 더 작은 학생 선택
            }
        }

        // 임시 반장 번호 출력
        System.out.println(president);
    }
}

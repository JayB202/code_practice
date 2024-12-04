import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalGradePoints = 0.0; // (학점 × 과목평점)의 합
        double totalCredits = 0.0;    // 학점의 총합

        for (int i = 0; i < 20; i++) {
            String subject = scanner.next(); // 과목명
            double credits = scanner.nextDouble(); // 학점
            String grade = scanner.next(); // 등급

            double gradePoint = getGradePoint(grade);

            // "P" 등급은 계산에서 제외
            if (!grade.equals("P")) {
                totalGradePoints += credits * gradePoint;
                totalCredits += credits;
            }
        }

        // 전공평점 계산
        double majorGPA = totalGradePoints / totalCredits;

        // 결과 출력
        System.out.printf("%.6f\n", majorGPA);
    }

    // 등급을 과목평점으로 변환하는 함수
    private static double getGradePoint(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0; // "P" 또는 잘못된 입력에 대한 기본 값
        }
    }
}

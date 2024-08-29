import java.util.*;

public class Main {
    static int k;
    static char[] signs; // 부등호 기호 배열
    static boolean[] visited = new boolean[10]; // 숫자 선택 여부 배열
    static List<String> answers = new ArrayList<>(); // 가능한 숫자 조합을 저장할 리스트

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt(); // 부등호 기호의 개수 입력
        scanner.nextLine();  // 줄바꿈 문자 처리
        signs = scanner.nextLine().replaceAll("\\s+", "").toCharArray(); // 부등호 기호 배열 입력

        // DFS를 사용하여 가능한 모든 숫자 조합 생성
        dfs(0, "");

        // 가능한 숫자 조합을 정렬
        Collections.sort(answers);
        
        // 가장 큰 값과 가장 작은 값 출력
        System.out.println(answers.get(answers.size() - 1));
        System.out.println(answers.get(0));
    }

    // 부등호 비교 메소드
    static boolean check(int a, int b, char op) {
        if (op == '<') {
            return a < b; // a가 b보다 작으면 참
        } else if (op == '>') {
            return a > b; // a가 b보다 크면 참
        }
        return false; // 부등호가 '<' 또는 '>'가 아닐 경우 거짓
    }

    // DFS 탐색 메소드
    static void dfs(int cnt, String num) {
        if (cnt == k + 1) { // k+1개의 숫자를 모두 사용한 경우
            answers.add(num); // 현재 조합을 리스트에 추가
            return;
        }

        for (int i = 0; i < 10; i++) { // 0부터 9까지의 숫자 탐색
            if (visited[i]) continue; // 이미 사용된 숫자는 건너뜀

            if (cnt == 0 || check(Character.getNumericValue(num.charAt(cnt - 1)), i, signs[cnt - 1])) {
                // 첫 숫자이거나 현재 숫자와 부등호 조건을 만족하는 경우
                visited[i] = true; // 숫자 선택 표시
                dfs(cnt + 1, num + i); // 다음 숫자 탐색
                visited[i] = false; // 숫자 선택 해제
            }
        }
    }
}

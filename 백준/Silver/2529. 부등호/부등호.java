import java.util.*;

public class Main {
    static int k;
    static char[] signs;
    static boolean[] visited = new boolean[10];
    static List<String> answers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        signs = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

        dfs(0, "");
        Collections.sort(answers);
        System.out.println(answers.get(answers.size() - 1));
        System.out.println(answers.get(0));
    }

    // 부등호 비교 메소드
    static boolean check(int a, int b, char op) {
        if (op == '<') {
            return a < b;
        } else if (op == '>') {
            return a > b;
        }
        return false;
    }

    // DFS 탐색 메소드
    static void dfs(int cnt, String num) {
        if (cnt == k + 1) {
            answers.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;

            if (cnt == 0 || check(Character.getNumericValue(num.charAt(cnt - 1)), i, signs[cnt - 1])) {
                visited[i] = true;
                dfs(cnt + 1, num + i);
                visited[i] = false;
            }
        }
    }
}

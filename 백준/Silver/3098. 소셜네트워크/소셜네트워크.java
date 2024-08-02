import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[][] snsArray;
    static Set<String> registerSet = new HashSet<>();
    static int n;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        snsArray = new int[n + 1][n + 1];

        // 자기자신에 대한 처리
        for (int i = 1; i < n + 1; i++) {
            snsArray[i][i] = 1;
        }
        // 친구관계 입력정보 처리
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            snsArray[x][y] = 1;
            snsArray[y][x] = 1;
        }

        int count = 0;
        Queue<Integer> setSize = new LinkedList<>();
        while (true) {
            int zeroCount = 0;

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i != j && snsArray[i][j] == 1) {
                        // 현재 행의 친구관계에 해당되는 행 탐색
                        bfs(i, j);
                    } else if (i != j && snsArray[i][j] == 0) {
                        zeroCount++;
                    }
                }
            }
            // 2차원 배열에서 0이 한번도 나오지 않았을 경우 반복문 중지
            if (zeroCount == 0) {
                break;
            } else {
                count++;
                setSize.offer(registerSet.size());
                Iterator<String> iterator = registerSet.iterator();
                while (iterator.hasNext()) {
                    String registerRequest = iterator.next();
                    String[] registerArray = registerRequest.split(",");

                    int x = Integer.parseInt(registerArray[0]);
                    int y = Integer.parseInt(registerArray[1]);

                    snsArray[x][y] = 1;
                    snsArray[y][x] = 1;
                }
                registerSet.clear();
            }
        }

        bw.write(count + "\n");
        while (!setSize.isEmpty()) {
            bw.write(setSize.poll() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // j행에서 i행과 친구관계가 아닌 열이 발견될 경우 해당 열과 i행에 대한 친구등록 신청
    private void bfs(int i, int j) {
        for (int index = 1; index < n + 1; index++) {
            if (index == i || index == j) {
                continue;
            } else {
                if (snsArray[j][index] == 1 && snsArray[i][index] == 0) {

                    // 친구의 친구 리스트중에서 i행과 서로 친구가 아닌 경우
                    String registerForm = "";
                    if (i < index) {
                        registerForm = String.valueOf(i) + "," + String.valueOf(index);
                    } else if (i > index) {
                        registerForm = String.valueOf(index) + "," + String.valueOf(i);
                    }

                    registerSet.add(registerForm);
                }
            }
        }
    }
}
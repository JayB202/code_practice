import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행렬의 크기 입력 받기
        String[] dimensions = br.readLine().split(" ");
        int M = Integer.parseInt(dimensions[0]);
        int N = Integer.parseInt(dimensions[1]);

        // 행렬 선언
        int[][] matrix = new int[M][N];

        // 행렬 입력 받기
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            if (line.length() != N) {
                System.out.println("잘못된 입력 길이: " + line.length() + " 기대한 길이: " + N);
                return;
            }
            for (int j = 0; j < N; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        // 행렬 좌우 반전 후 출력
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                System.out.print(matrix[i][j]);
            }
            if (i < M - 1) { // 마지막 줄이 아니면 줄바꿈
                System.out.println();
            }
        }
    }
}

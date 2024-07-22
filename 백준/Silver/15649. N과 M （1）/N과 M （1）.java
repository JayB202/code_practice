import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();

        boolean[] used = new boolean[N + 1];
        int[] sequence = new int[M];
        
        generateSequences(N, M, 0, sequence, used);
    }

    private static void generateSequences(int N, int M, int depth, int[] sequence, boolean[] used) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                sequence[depth] = i;
                generateSequences(N, M, depth + 1, sequence, used);
                used[i] = false;
            }
        }
    }
}

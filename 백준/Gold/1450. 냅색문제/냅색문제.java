import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> leftSums = new ArrayList<>();
    static ArrayList<Long> rightSums = new ArrayList<>();
    static long C;
    static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, N / 2, 0, leftSums);
        dfs(N / 2, N, 0, rightSums);

        Collections.sort(rightSums);

        long answer = 0;
        for (long s : leftSums) {
            answer += upperBound(rightSums, C - s);
        }

        System.out.println(answer);
    }

    static void dfs(int start, int end, long sum, ArrayList<Long> list) {
        if (sum > C) return;
        if (start == end) {
            list.add(sum);
            return;
        }
        dfs(start + 1, end, sum, list);
        dfs(start + 1, end, sum + weights[start], list);
    }

    static long upperBound(ArrayList<Long> list, long target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

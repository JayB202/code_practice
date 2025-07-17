import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        int deadline;
        int ramen;

        Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Problem o) {
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Problem> problems = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            problems.add(new Problem(d, r));
        }

        Collections.sort(problems);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Problem p : problems) {
            pq.offer(p.ramen);
            if (pq.size() > p.deadline) {
                pq.poll();
            }
        }

        long answer = 0;
        for (int r : pq) answer += r;
        System.out.println(answer);
    }
}

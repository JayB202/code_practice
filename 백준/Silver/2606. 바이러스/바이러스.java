import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] network = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            network[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int nextCom = Integer.parseInt(st.nextToken());

            network[com].add(nextCom);
            network[nextCom].add(com);
        }

        System.out.println(bfs(n,network));
//        System.out.println(dfs(n,network));

    }

    private static int dfs(int n, List<Integer>[] network) {
        boolean[] infection = new boolean[n+1];
        Deque<Integer> stack = new ArrayDeque<>();
        //초기값
        infection[1] = true;
        stack.push(1);

        int cnt = 0;

        while(!stack.isEmpty()){
            int current = stack.pop();
            for(int next : network[current]){
                if(!infection[next]){
                    cnt++;
                    infection[next] = true;
                    stack.push(next);
                }
            }
        }

        return cnt;
    }


    private static int bfs(int n, List<Integer>[] network) {
        boolean[] infection = new boolean[n+1];
        Deque<Integer> que = new ArrayDeque<>();
        //초기값
        infection[1] = true;
        que.offer(1);

        //1번은 감염되기에
        int cnt = 0;
        while(!que.isEmpty()){
            int current = que.poll();
            List<Integer> currentNet = network[current];
            for (int i = 0; i < currentNet.size(); i++) {
                int next = currentNet.get(i);
                if(!infection[next]){
                    cnt++;
                    infection[next] = true;
                    que.offer(next);
                }
            }
        }
        return cnt;
    }
}
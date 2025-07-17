import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;

            parent = new int[m];
            for (int i = 0; i < m; i++) parent[i] = i;

            List<Edge> edges = new ArrayList<>();
            long total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x, y, z));
                total += z;
            }

            Collections.sort(edges);
            long mst = 0;
            for (Edge e : edges) {
                if (find(e.u) != find(e.v)) {
                    union(e.u, e.v);
                    mst += e.w;
                }
            }

            System.out.println(total - mst);
        }
    }
}

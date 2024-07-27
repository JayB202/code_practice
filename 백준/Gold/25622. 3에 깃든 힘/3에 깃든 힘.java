import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_N = 4000000;
    static int n, cntRoot;
    static ArrayList<Integer>[] adj = new ArrayList[MAX_N];
    static boolean[][] stop = new boolean[MAX_N][];
    static boolean[] root = new boolean[MAX_N];
    
    // Initialize adjacency lists
    static {
        for (int i = 0; i < MAX_N; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    
    static int dfs(int i, int s, int e) {
        int sub = 1;
        int par = -1;
        for (int j = 0; j < adj[s].size(); j++) {
            int u = adj[s].get(j);
            if (u != e) {
                sub += dfs(j, u, s);
            } else {
                par = j;
            }
        }
        if (sub % 3 == 0) {
            if (e >= 0 && i < stop[e].length) {
                stop[e][i] = true;
            }
            if (s != 1 && par >= 0 && par < stop[s].length) {
                stop[s][par] = true;
            }
            cntRoot++;
            root[s] = true;
        }
        return sub;
    }
    
    static void dfs1(int s, int e, PrintWriter pw) {
        pw.print(s + " ");
        for (int i = 0; i < adj[s].size(); i++) {
            int u = adj[s].get(i);
            if (u != e) {
                if (stop[s].length > i && !stop[s][i]) {
                    dfs1(u, s, pw);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        
        for (int i = 0; i <= n; i++) {
            stop[i] = new boolean[adj[i].size()];
        }
        
        dfs(0, 1, 0);
        
        if (cntRoot != n / 3) {
            pw.println("U");
        } else {
            pw.println("S");
            for (int i = 1; i <= n; i++) {
                if (root[i]) {
                    dfs1(i, 0, pw);
                    pw.println();
                }
            }
        }
        
        pw.flush();
        pw.close();
        br.close();
    }
}

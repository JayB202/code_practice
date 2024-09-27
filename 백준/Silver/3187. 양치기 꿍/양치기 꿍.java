import java.util.*;

public class Main {
    static int R, C;
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int sheepAlive = 0, wolfAlive = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();  // 개행문자 처리
        
        field = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                field[i][j] = line.charAt(j);
            }
        }
        
        // 울타리로 나뉜 각 구역을 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && field[i][j] != '#') {
                    bfs(i, j);  // 새로운 구역 탐색 시작
                }
            }
        }
        
        // 결과 출력
        System.out.println(sheepAlive + " " + wolfAlive);
    }

    // BFS 탐색
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int sheep = 0, wolf = 0;
        
        // 첫 좌표에서 양 또는 늑대를 확인
        if (field[x][y] == 'k') sheep++;
        if (field[x][y] == 'v') wolf++;
        
        // 인접한 영역을 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && field[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    
                    if (field[nx][ny] == 'k') sheep++;
                    if (field[nx][ny] == 'v') wolf++;
                }
            }
        }
        
        // 영역 내에서 양과 늑대의 수를 비교하여 결과 처리
        if (sheep > wolf) {
            sheepAlive += sheep;
        } else {
            wolfAlive += wolf;
        }
    }
}

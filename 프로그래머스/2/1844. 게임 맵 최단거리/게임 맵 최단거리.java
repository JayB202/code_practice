import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 방향 벡터: 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 네 방향으로 이동 가능
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵의 범위를 벗어나지 않고, 벽이 아닌 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    // 처음 방문하는 칸에 대해 이동 거리를 기록
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        
        // 상대 팀 진영에 도착할 수 없으면 -1을 반환
        if (maps[n - 1][m - 1] == 1) {
            return -1;
        }
        
        // 상대 팀 진영에 도착한 경우 그때까지의 최단 거리를 반환
        return maps[n - 1][m - 1];
    }
}

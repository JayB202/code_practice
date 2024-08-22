import java.util.*;

class Solution {
        public int solution(String[] board) {
        // 보드의 크기
        int n = board.length;
        int m = board[0].length();
        
        // 로봇의 시작 위치와 목표 위치를 찾기 위한 변수
        int startX = -1, startY = -1;
        int goalX = -1, goalY = -1;
        
        // 보드에서 로봇과 목표의 위치를 찾음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }
        
        // BFS 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        // BFS 시작
        queue.add(new int[] { startX, startY, 0 }); // x, y, 이동 횟수
        visited[startX][startY] = true;
        
        // 방향 벡터 (상, 하, 좌, 우)
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            // 목표 위치에 도달한 경우
            if (x == goalX && y == goalY) {
                return dist;
            }
            
            // 모든 방향에 대해 이동을 시도
            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;
                
                // 현재 방향으로 계속 이동
                while (isValid(nx + dx[d], ny + dy[d], n, m, board)) {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                // 도착한 위치가 아직 방문하지 않은 경우
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] { nx, ny, dist + 1 });
                }
            }
        }
        
        // 목표 위치에 도달할 수 없는 경우
        return -1;
    }
    
    
    // 이동 가능한 위치인지 확인하는 메서드
    private boolean isValid(int x, int y, int n, int m, String[] board) {
        return x >= 0 && x < n && y >= 0 && y < m && board[x].charAt(y) != 'D';
    }
}
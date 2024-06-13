class Solution {
    public int solution(int n, int[][] results) {
        // 그래프 초기화
        boolean[][] dist = new boolean[n][n];
        
        // 자기 자신으로 가는 경로는 true로 설정
        for (int i = 0; i < n; i++) {
            dist[i][i] = true;
        }
        
        // 경기 결과를 반영하여 초기 그래프 구성
        for (int[] result : results) {
            int winner = result[0] - 1;
            int loser = result[1] - 1;
            dist[winner][loser] = true;
        }
        
        // Floyd-Warshall 알고리즘 적용
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] && dist[k][j]) {
                        dist[i][j] = true;
                    }
                }
            }
        }
        
        // 순위를 정확히 매길 수 있는 선수 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean known = true;
            for (int j = 0; j < n; j++) {
                if (i != j && !(dist[i][j] || dist[j][i])) {
                    known = false;
                    break;
                }
            }
            if (known) {
                answer += 1;
            }
        }
        
        return answer;
    }
}

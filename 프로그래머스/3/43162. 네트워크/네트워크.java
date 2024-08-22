class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];  // 방문한 컴퓨터를 추적하기 위한 배열
        int answer = 0;  // 네트워크의 개수

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // 방문하지 않은 컴퓨터가 있다면
                dfs(i, computers, visited);  // DFS를 통해 연결된 모든 컴퓨터를 방문
                answer++;  // 새로운 네트워크를 발견했으므로 증가
            }
        }

        return answer;  // 네트워크의 총 개수를 반환
    }

    private void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;  // 현재 컴퓨터를 방문 처리

        for (int i = 0; i < computers.length; i++) {
            // 현재 컴퓨터와 연결된 컴퓨터를 방문
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);  // 재귀적으로 연결된 컴퓨터를 방문
            }
        }
    }
}

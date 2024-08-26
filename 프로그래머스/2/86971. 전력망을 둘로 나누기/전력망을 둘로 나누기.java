import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 그래프를 인접 리스트 형태로 변환
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프에 전선 정보 추가
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        // 각 전선을 끊어보면서 최소 차이 계산
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            
            // 전선을 끊는다.
            graph.get(node1).remove((Integer) node2);
            graph.get(node2).remove((Integer) node1);
            
            // 끊은 뒤 두 개의 트리로 나누어졌을 때의 노드 개수 계산
            int count = bfsCount(graph, node1, n);
            
            // 두 네트워크의 송전탑 개수 차이의 최소값 갱신
            answer = Math.min(answer, Math.abs(n - 2 * count));
            
            // 전선을 다시 연결해 복구
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        return answer;
    }
    
    // BFS를 사용하여 특정 노드로부터 연결된 모든 노드 개수를 세는 함수
    private int bfsCount(ArrayList<ArrayList<Integer>> graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        
        return count;
    }
}

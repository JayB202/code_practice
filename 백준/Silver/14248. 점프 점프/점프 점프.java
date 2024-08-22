import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // 돌의 개수
        int[] stones = new int[n]; // 각 돌의 점프 거리 저장
        for (int i = 0; i < n; i++) {
            stones[i] = scanner.nextInt();
        }
        int start = scanner.nextInt(); // 출발점 (1-based index)
        scanner.close();
        
        // 방문 가능한 돌의 개수를 계산하는 함수 호출
        System.out.println(countReachableStones(stones, start - 1));
    }
    
    public static int countReachableStones(int[] stones, int start) {
        int n = stones.length;
        boolean[] visited = new boolean[n]; // 방문 여부를 체크하는 배열
        Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐
        
        // BFS 시작
        queue.add(start);
        visited[start] = true;
        int count = 0; // 방문 가능한 돌의 개수
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            
            // 현재 돌에서 점프할 수 있는 거리
            int jumpDistance = stones[current];
            
            // 왼쪽으로 점프 (current - jumpDistance)
            if (current - jumpDistance >= 0 && !visited[current - jumpDistance]) {
                visited[current - jumpDistance] = true;
                queue.add(current - jumpDistance);
            }
            
            // 오른쪽으로 점프 (current + jumpDistance)
            if (current + jumpDistance < n && !visited[current + jumpDistance]) {
                visited[current + jumpDistance] = true;
                queue.add(current + jumpDistance);
            }
        }
        
        return count;
    }
}
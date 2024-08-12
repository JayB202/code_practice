import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] costs) {
        //간선 비용을 오름차순으로 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        // Union-Find 자료구조 초기화
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 간선의 가중치 합산
        int totalCost = 0;
        int edgeCount = 0; // 현재 추가한 간선 수

        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int costValue = cost[2];

            // 사이클이 형성되지 않도록 Union-Find 사용
            if (find(parent, island1) != find(parent, island2)) {
                union(parent, island1, island2);
                totalCost += costValue;
                edgeCount++;
                
                // 모든 섬이 연결되면 종료
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }

    // 두 원소가 같은 집합에 속하는지 확인
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // 경로 압축
        }
        return parent[x];
    }

    // 두 집합을 합침
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX; // 간단한 union
        }
    }
}

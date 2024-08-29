import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 우선순위 큐를 사용하여 가장 많은 적이 등장하는 라운드를 우선 처리합니다.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int usedInvincibility = 0; // 사용한 무적권의 수
        long totalEnemies = 0; // 누적된 적의 수

        for (int i = 0; i < enemy.length; i++) {
            totalEnemies += enemy[i];
            pq.add(enemy[i]);
            
            if (totalEnemies > n) {
                // 병사 수가 부족할 때 무적권을 사용
                if (usedInvincibility < k) {
                    totalEnemies -= pq.poll(); // 가장 많은 적의 수를 제거
                    usedInvincibility++;
                } else {
                    // 무적권이 부족한 경우, 게임 종료
                    return i;
                }
            }
        }

        // 모든 라운드를 통과할 수 있는 경우
        return enemy.length;
    }
}

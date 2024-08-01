import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 배열을 우선순위 큐에 삽입
        for (int scov : scoville) {
            minHeap.add(scov);
        }
        
        int mixCount = 0;
        
        while (minHeap.size() > 1) {
            int min1 = minHeap.poll(); // 가장 낮은 스코빌 지수
            if (min1 >= K) {
                return mixCount;
            }
            
            int min2 = minHeap.poll(); // 두 번째로 낮은 스코빌 지수
            int newScoville = min1 + (min2 * 2);
            minHeap.add(newScoville);
            mixCount++;
        }
        
        // 마지막 남은 음식의 스코빌 지수가 K 이상인지 확인
        if (minHeap.peek() >= K) {
            return mixCount;
        } else {
            return -1;
        }
    }
}

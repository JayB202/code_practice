import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        
        // 각 기능의 완료일 계산
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int daysToComplete = (int) Math.ceil((100.0 - progress) / speed);
            days.add(daysToComplete);
        }
        
        // 큐를 사용하여 배포되는 기능의 수를 집계
        Queue<Integer> queue = new LinkedList<>(days);
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int currentDay = queue.poll();
            int count = 1;
            
            // 현재 기능이 배포되는 날까지, 후속 기능이 배포될 수 있는지 확인
            while (!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                count++;
            }
            
            result.add(count);
        }
        
        // List를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}

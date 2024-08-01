import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최소 힙과 최대 힙을 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> deleted = new HashSet<>();
        
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                // 입력 명령이 있을 경우 두 개의 힙에 값을 추가
                minHeap.offer(value);
                maxHeap.offer(value);
                deleted.add(value);
            } else if (command.equals("D")) {
                if (value == 1) {
                    // 최대값 삭제 
                    while (!maxHeap.isEmpty() && !deleted.contains(maxHeap.peek())) {
                        maxHeap.poll();
                    }
                    if (!maxHeap.isEmpty()) {
                        int max = maxHeap.poll();
                        deleted.remove(max);
                    }
                } else if (value == -1) {
                    // 최소값 삭제 
                    while (!minHeap.isEmpty() && !deleted.contains(minHeap.peek())) {
                        minHeap.poll();
                    }
                    if (!minHeap.isEmpty()) {
                        int min = minHeap.poll();
                        deleted.remove(min);
                    }
                }
            }
        }
        
        // 힙에서 최솟값과 최댓값
        while (!maxHeap.isEmpty() && !deleted.contains(maxHeap.peek())) {
            maxHeap.poll();
        }
        while (!minHeap.isEmpty() && !deleted.contains(minHeap.peek())) {
            minHeap.poll();
        }
        
        int max = maxHeap.isEmpty() ? 0 : maxHeap.peek();
        int min = minHeap.isEmpty() ? 0 : minHeap.peek();
        
        return new int[]{max, min};
    }
}

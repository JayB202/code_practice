import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 풍선의 개수 읽기
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new LinkedList<>();

        // 두 번째 줄에서 풍선의 값을 읽고 덱에 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(input[i]);
            deque.add(new int[]{i + 1, value}); // 풍선 번호와 값 저장
        }

        StringBuilder result = new StringBuilder();

        // 덱이 비어 있을 때까지 반복
        while (!deque.isEmpty()) {
            int[] balloon = deque.poll(); // 현재 터뜨릴 풍선을 꺼냄
            int balloonNumber = balloon[0];
            int move = balloon[1];
            result.append(balloonNumber).append(" ");

            if (!deque.isEmpty()) {
                if (move > 0) {
                    // 오른쪽으로 이동
                    move = (move - 1) % deque.size();
                    for (int i = 0; i < move; i++) {
                        deque.addLast(deque.pollFirst());
                    }
                } else {
                    // 왼쪽으로 이동
                    move = (-move) % deque.size();
                    for (int i = 0; i < move; i++) {
                        deque.addFirst(deque.pollLast());
                    }
                }
            }
        }

        System.out.println(result);
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        // 사람들 큐 초기화
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        // 결과를 저장할 리스트 초기화
        StringBuilder result = new StringBuilder();
        result.append("<");
        
        // 요세푸스 순열을 구하기 위한 루프
        while (!queue.isEmpty()) {
            // K번째 사람을 찾아서 제거
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.remove());
            }
            result.append(queue.remove());
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }
        
        result.append(">");
        
        System.out.println(result);
        
        scanner.close();
    }
}
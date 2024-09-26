// 입력 
//    첫 번째 줄: n (아이들과 거점지를 방문한 횟수)
//    다음 n줄:
//        a가 주어지고, 그 다음 a개의 숫자는 거점지에서 충전한 선물들의 가치 (양의 정수)
//        a가 0이면 아이들을 만난 것이고, 줄 선물이 없다면 -1을 출력
// 로직 
//    최대 힙 사용: 선물의 가치를 빠르게 확인하고 줄 수 있도록 최대 힙을 사용. 
//        아이를 만날 때마다 가장 가치가 큰 선물을 힙에서 꺼냄.
//    선물 충전: a > 0인 경우에는 해당 선물들을 모두 힙에 넣음.
//    아이를 만남: a == 0인 경우에는 힙에서 가장 가치가 큰 선물을 꺼내서 출력. 
//        만약 힙에 선물이 없다면 -1을 출력.
// 출력 
//    a == 0인 경우마다 선물의 가치를 출력하거나, 없을 경우 -1을 출력


import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int n = sc.nextInt(); // 아이들과 거점지 방문 횟수
        
        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            
            if (a > 0) {
                // 거점지에서 선물을 충전
                for (int j = 0; j < a; j++) {
                    int giftValue = sc.nextInt();
                    gifts.add(giftValue); // 선물 충전
                }
            } else {
                // 아이들을 만난 경우
                if (gifts.isEmpty()) {
                    System.out.println(-1); // 줄 선물이 없을 때
                } else {
                    System.out.println(gifts.poll()); // 가장 큰 선물 주기
                }
            }
        }
        
        sc.close();
    }
}

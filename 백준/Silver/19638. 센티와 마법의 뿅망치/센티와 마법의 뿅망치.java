// 입력 
//    첫 번째 줄: 세 개의 정수 N (거인의 수), Hcenti (센티의 키), T (마법의 뿅망치 사용 가능 횟수)
//    두 번째 줄부터 N개의 줄: 각 거인의 키 H
//로직 (Logic)
//     최대 힙 사용: 거인의 키 중 가장 큰 값을 빠르게 찾아내기 위해 최대 힙을 사용. 
//        최대 힙에서 가장 큰 값부터 뿅망치를 사용하여 키를 절반으로 줄임.
//     반복: 뿅망치를 T회 사용할 수 있기 때문에 최대 T번 반복. 
//        매번 힙에서 가장 큰 거인의 키를 꺼내서 절반으로 줄인 뒤 다시 힙에 넣음.
//     조건 확인: 매번 거인의 키가 센티의 키보다 작아지면 바로 종료하고 결과를 출력. 
//        그렇지 않으면 주어진 뿅망치 횟수를 모두 사용한 후에도 키가 큰 거인이 있는지 확인.
//출력:
//    센티보다 모든 거인의 키가 작아졌으면 YES와 사용한 뿅망치 횟수를 출력.
//    그렇지 않으면 NO와 가장 큰 거인의 키를 출력.


import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        int N = sc.nextInt(); // 거인의 수
        int Hcenti = sc.nextInt(); // 센티의 키
        int T = sc.nextInt(); // 마법의 뿅망치 사용 가능 횟수
        
        PriorityQueue<Integer> giants = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 사용
        
        for (int i = 0; i < N; i++) {
            int height = sc.nextInt();
            giants.add(height); // 거인들의 키 입력
        }
        
        int hammerCount = 0; // 마법의 뿅망치 사용 횟수

        // 뿅망치 사용 가능 횟수 내에서 거인의 키 줄이기
        while (hammerCount < T) {
            int tallest = giants.poll(); // 가장 큰 거인의 키
            
            if (tallest < Hcenti) {
                // 모든 거인이 센티보다 작아졌을 경우
                System.out.println("YES");
                System.out.println(hammerCount);
                return;
            }
            
            if (tallest == 1) {
                // 더 이상 키를 줄일 수 없는 경우
                giants.add(tallest);
                break;
            }
            
            // 키를 절반으로 줄이기
            int newHeight = tallest / 2;
            giants.add(newHeight);
            hammerCount++;
        }
        
        // 최종 결과 확인
        int tallestAfter = giants.peek();
        
        if (tallestAfter < Hcenti) {
            System.out.println("YES");
            System.out.println(hammerCount);
        } else {
            System.out.println("NO");
            System.out.println(tallestAfter);
        }
        
        sc.close();
    }
}

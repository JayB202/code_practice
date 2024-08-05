import java.util.*;

class Main {
    public static void main(String[] args) {
        // Scanner 객체를 생성하여 표준 입력을 읽어들임
        Scanner sc = new Scanner(System.in);
        
        // 첫째 줄: 상근이가 가지고 있는 숫자 카드의 개수 N을 입력받음
        int N = sc.nextInt();
        
        // HashMap을 생성하여 각 카드의 빈도 수를 저장
        Map<Integer, Integer> cardCount = new HashMap<>();
        
        // 숫자 카드의 값들을 입력받아 HashMap에 빈도 수 저장
        for (int i = 0; i < N; i++) {
            int card = sc.nextInt();
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        // 셋째 줄: 확인할 숫자의 개수 M을 입력받음
        int M = sc.nextInt();
        
        // 결과를 저장할 StringBuilder 객체 생성
        StringBuilder result = new StringBuilder();
        
        // M개의 숫자를 입력받아 각 숫자의 빈도 수를 조회
        for (int i = 0; i < M; i++) {
            int query = sc.nextInt();
            // 카드가 존재하면 해당 빈도 수를, 존재하지 않으면 0을 출력
            result.append(cardCount.getOrDefault(query, 0)).append(" ");
        }
        

        System.out.println(result.toString().trim());

        sc.close();
    }
}

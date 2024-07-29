import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 보석의 수
        int K = Integer.parseInt(st.nextToken()); // 가방의 수

        // 보석 정보를 담을 리스트
        List<int[]> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels.add(new int[] {weight, value});
        }

        // 가방의 최대 무게를 담을 리스트
        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        // 보석 리스트를 무게를 기준으로 정렬 (오름차순)
        jewels.sort(Comparator.comparingInt(a -> a[0]));
        
        // 가방 리스트를 무게를 기준으로 정렬 (오름차순)
        bags.sort(Integer::compareTo);

        // 최대 힙 (우선순위 큐)를 사용하여 최대 가격을 관리
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long maxTotalValue = 0;
        int jewelIndex = 0;
        
        // 각 가방의 최대 무게에 대해 적절한 보석을 선택
        for (int bagWeight : bags) {
            // 현재 가방에 담을 수 있는 모든 보석을 힙에 추가
            while (jewelIndex < N && jewels.get(jewelIndex)[0] <= bagWeight) {
                maxHeap.add(jewels.get(jewelIndex)[1]);
                jewelIndex++;
            }
            
            // 힙에서 가장 비싼 보석을 선택하고, 총 가격에 추가
            if (!maxHeap.isEmpty()) {
                maxTotalValue += maxHeap.poll();
            }
        }

        // 결과 출력
        System.out.println(maxTotalValue);
    }
}
